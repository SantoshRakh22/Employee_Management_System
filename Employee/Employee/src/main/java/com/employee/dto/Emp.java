package com.employee.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Emp {
    @NotBlank(message = "FirstName is required")
    private String firstName;
    @NotBlank(message = "LastName is required")
    private String lastName;
    @NotNull(message = "BirthDate is required")
    private LocalDate birthDate;
    @NotBlank(message = "Gender is required")
    private String gender;
    @NotNull(message = "JoiningDate is required")
    private LocalDate joiningDate;
    @NotNull(message = "Salary is required")
    @DecimalMin(value = "0.01", message = "Salary must have at least 2 decimal places")
    private BigDecimal salary;

    private String qualification;
    private String isFresherEmployee;
    private Long tempId;

    public Long getTempId() {
        return tempId;
    }

    public void setTempId(Long tempId) {
        this.tempId = tempId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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

    public String getIsFresherEmployee() {
        return isFresherEmployee;
    }

    public void setIsFresherEmployee(String isFresherEmployee) {
        this.isFresherEmployee = isFresherEmployee;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", joiningDate=" + joiningDate +
                ", salary=" + salary +
                ", qualification='" + qualification + '\'' +
                ", isFresherEmployee='" + isFresherEmployee + '\'' +
                ", tempId=" + tempId +
                '}';
    }

    public Emp(String firstName, String lastName, LocalDate birthDate, String gender, LocalDate joiningDate, BigDecimal salary, String qualification, String isFresherEmployee, Long tempId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.joiningDate = joiningDate;
        this.salary = salary;
        this.qualification = qualification;
        this.isFresherEmployee = isFresherEmployee;
        this.tempId = tempId;
    }

    public Emp() {
    }
}
