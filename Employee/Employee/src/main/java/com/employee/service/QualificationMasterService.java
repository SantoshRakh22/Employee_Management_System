package com.employee.service;

import com.employee.model.QualificationMaster;
import com.employee.repo.QualificationMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationMasterService {
    @Autowired
    private QualificationMasterRepository qualificationMasterRepository;

    public List<QualificationMaster> getAllData(){
        List<QualificationMaster> l = qualificationMasterRepository.findAll();
        return l;
    }

    public QualificationMaster getById(Long id){
        return qualificationMasterRepository.findById(id).get();
    }
}
