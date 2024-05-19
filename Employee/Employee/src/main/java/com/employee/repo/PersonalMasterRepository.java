package com.employee.repo;

import com.employee.model.PersonalMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalMasterRepository extends JpaRepository<PersonalMaster, Long> {
}
