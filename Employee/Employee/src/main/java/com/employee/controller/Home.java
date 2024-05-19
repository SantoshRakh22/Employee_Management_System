package com.employee.controller;

import com.employee.dto.Emp;
import com.employee.helper.Message;
import com.employee.model.EmployeeMaster;
import com.employee.model.PersonalMaster;
import com.employee.model.QualificationMaster;
import com.employee.service.EmployeeMasterService;
import com.employee.service.PersonalMasterService;
import com.employee.service.QualificationMasterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Controller
public class Home {
    @Autowired
    private EmployeeMasterService employeeMasterService;
    @Autowired
    private QualificationMasterService qualificationMasterService;

    @Autowired
    private PersonalMasterService personalMasterService;
    @ModelAttribute
    public void commonUser(Principal p, Model m) {
        List<QualificationMaster> dynamicValues = qualificationMasterService.getAllData();
        m.addAttribute("dynamicValues", dynamicValues);
        List<EmployeeMaster> employeeMasters = employeeMasterService.AllDataEmployeeMasters();
        m.addAttribute("allData", employeeMasters);
        System.out.println(employeeMasters);
    }
    @GetMapping("/employee")
    public String register(Model m) {
        m.addAttribute("emp",new Emp());
        return "employee";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute Emp emp,BindingResult result,  HttpSession session, Model m, HttpServletRequest request){
        if(result.hasErrors()) {
            System.out.println(result);
            return "employee";
        }
        LocalDate joiningDate = emp.getJoiningDate();
        LocalDate birthDate = emp.getBirthDate();
        Period period = Period.between(birthDate, joiningDate);
        if (period.getYears() < 18) {
            session.setAttribute("message",new Message("The difference between joiningDate and birthDate must be more than 18 years","alert-danger"));
            return "employee";
        }
        else{
            System.out.println(emp);
            PersonalMaster personalMaster = new PersonalMaster();
            personalMaster.setFirstName(emp.getFirstName());
            personalMaster.setLastName(emp.getLastName());
            personalMaster.setBirthDate(emp.getBirthDate());
            personalMaster.setGender(emp.getGender());
            EmployeeMaster employeeMaster = new EmployeeMaster();
            employeeMaster.setPersonalMaster(personalMaster);
            employeeMaster.setJoiningDate(emp.getJoiningDate());
            employeeMaster.setSalary(emp.getSalary());
            employeeMaster.setQualificationMaster(qualificationMasterService.getById(Long.valueOf(emp.getQualification())));
            employeeMaster.setIsFresherEmployee(emp.getIsFresherEmployee());
            EmployeeMaster employeeMaster1 = employeeMasterService.saveData(employeeMaster);
            if (employeeMaster1 != null) {
                session.setAttribute("message",new Message("Successfully Saved !!","alert-success"));
            } else {
                session.setAttribute("message",new Message("Something wrong server","alert-danger"));
            }
            return "redirect:/employee";
        }
    }

    @PostMapping("/update-register-details/{id}")
    public String updateRegisterData(Model model, @PathVariable("id") Long id) {
        Emp emp = new Emp();
        EmployeeMaster master = employeeMasterService.getById(id);
        emp.setTempId(id);
        emp.setFirstName(master.getPersonalMaster().getFirstName());
        emp.setLastName(master.getPersonalMaster().getLastName());
        emp.setGender(master.getPersonalMaster().getGender());
        emp.setBirthDate(master.getPersonalMaster().getBirthDate());
        emp.setJoiningDate(master.getJoiningDate());
        emp.setSalary(master.getSalary());
        emp.setQualification(master.getQualificationMaster().getQualification());

        emp.setIsFresherEmployee(master.getIsFresherEmployee());
        model.addAttribute("emp",emp);
        return"update";
    }

    @PostMapping("/updateUser")
    public String updateUser(@Valid @ModelAttribute Emp emp,BindingResult result,  HttpSession session, Model m, HttpServletRequest request){
        if(result.hasErrors()) {
            System.out.println(result);
            return "update";

        }
        LocalDate joiningDate = emp.getJoiningDate();
        LocalDate birthDate = emp.getBirthDate();
        Period period = Period.between(birthDate, joiningDate);
        if (period.getYears() < 18) {
            session.setAttribute("message",new Message("The difference between joiningDate and birthDate must be more than 18 years","alert-danger"));
            return "update";
        }else{
            EmployeeMaster employeeMaster_old_data = employeeMasterService.getById(emp.getTempId());
            System.out.println("new_data => "+emp);
            System.out.println("old_data => "+employeeMaster_old_data);
            System.out.println("old_id => "+employeeMaster_old_data.getPersonalMaster().getId());
            Long id = employeeMaster_old_data.getPersonalMaster().getId();
            employeeMaster_old_data.setJoiningDate(emp.getJoiningDate());
            employeeMaster_old_data.setSalary(emp.getSalary());
            PersonalMaster master = personalMasterService.getById(id);
            master.setFirstName(emp.getFirstName());
            master.setLastName(emp.getLastName());
            master.setBirthDate(emp.getBirthDate());
            master.setGender(emp.getGender());
            personalMasterService.save(master);
            employeeMaster_old_data.setQualificationMaster(qualificationMasterService.getById(Long.valueOf(emp.getQualification())));
            employeeMaster_old_data.setIsFresherEmployee(emp.getIsFresherEmployee());
            EmployeeMaster employeeMaster1 = employeeMasterService.saveData(employeeMaster_old_data);
            if (employeeMaster1 != null) {
                session.setAttribute("message",new Message("Successfully Updated !!","alert-success"));
            } else {
                session.setAttribute("message",new Message("Something wrong server","alert-danger"));
            }
            return "redirect:/employee";
        }
    }
}
