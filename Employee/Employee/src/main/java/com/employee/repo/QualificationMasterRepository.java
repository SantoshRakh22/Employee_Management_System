package com.employee.repo;

import com.employee.model.QualificationMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QualificationMasterRepository extends JpaRepository<QualificationMaster, Long> {
    List<QualificationMaster> findAll();
}

