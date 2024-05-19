package com.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class QualificationMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String qualification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public QualificationMaster(Long id, String qualification) {
        this.id = id;
        this.qualification = qualification;
    }

    public QualificationMaster() {
    }

    @Override
    public String toString() {
        return "QualificationMaster{" +
                "id=" + id +
                ", qualification='" + qualification + '\'' +
                '}';
    }
}
