package com.employee.service;

import com.employee.model.PersonalMaster;
import com.employee.repo.PersonalMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalMasterService {
    @Autowired
    private PersonalMasterRepository personalMasterRepository;

    // Service methods
    public PersonalMaster getById(Long id){
        return personalMasterRepository.findById(id).get();
    }

    public PersonalMaster save(PersonalMaster personalMaster){
        return personalMasterRepository.save(personalMaster);
    }
}
