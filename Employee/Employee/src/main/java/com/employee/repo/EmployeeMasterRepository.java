package com.employee.repo;

import com.employee.model.EmployeeMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeMasterRepository extends JpaRepository<EmployeeMaster, Long> {
}
