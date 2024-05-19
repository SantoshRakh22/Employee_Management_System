package com.employee.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class EmployeeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_id")
    private PersonalMaster personalMaster;
    private LocalDate joiningDate;
    private BigDecimal salary;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "qualification_id")
    private QualificationMaster qualificationMaster;
    private String isFresherEmployee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonalMaster getPersonalMaster() {
        return personalMaster;
    }

    public void setPersonalMaster(PersonalMaster personalMaster) {
        this.personalMaster = personalMaster;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public QualificationMaster getQualificationMaster() {
        return qualificationMaster;
    }

    public void setQualificationMaster(QualificationMaster qualificationMaster) {
        this.qualificationMaster = qualificationMaster;
    }

    public String getIsFresherEmployee() {
        return isFresherEmployee;
    }

    public void setIsFresherEmployee(String isFresherEmployee) {
        this.isFresherEmployee = isFresherEmployee;
    }

    public EmployeeMaster(Long id, PersonalMaster personalMaster, LocalDate joiningDate, BigDecimal salary, QualificationMaster qualificationMaster, String isFresherEmployee) {
        this.id = id;
        this.personalMaster = personalMaster;
        this.joiningDate = joiningDate;
        this.salary = salary;
        this.qualificationMaster = qualificationMaster;
        this.isFresherEmployee = isFresherEmployee;
    }

    public EmployeeMaster() {
    }

    @Override
    public String toString() {
        return "EmployeeMaster{" +
                "id=" + id +
                ", personalMaster=" + personalMaster +
                ", joiningDate=" + joiningDate +
                ", salary=" + salary +
                ", qualificationMaster=" + qualificationMaster +
                ", isFresherEmployee=" + isFresherEmployee +
                '}';
    }
}
