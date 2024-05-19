package com.employee.service;

import com.employee.model.EmployeeMaster;
import com.employee.repo.EmployeeMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeMasterService {
    @Autowired
    private EmployeeMasterRepository repository;

    public EmployeeMaster saveData(EmployeeMaster employeeMaster) {
        return repository.save(employeeMaster);
    }

    public List<EmployeeMaster> AllDataEmployeeMasters(){
        return repository.findAll();
    }

    public EmployeeMaster getById(Long id) {
        return repository.findById(id).get();
    }
}

