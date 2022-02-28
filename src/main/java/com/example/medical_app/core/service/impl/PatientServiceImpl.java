package com.example.medical_app.core.service.impl;

import com.example.medical_app.core.model.entity.PatientEntity;
import com.example.medical_app.core.repository.PatientEntityRepository;
import com.example.medical_app.core.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientEntityRepository patientEntityRepository;

    @Override
    public List<PatientEntity> getAllPatientEntity() {
        return patientEntityRepository.findAll();
    }

    @Override
    public void savePatientEntity(PatientEntity patientEntity) {
        patientEntityRepository.save(patientEntity);
    }

    @Override
    public void deletePatientEntity(Long id) {
        patientEntityRepository.deleteById(id);
    }

    @Override
    public PatientEntity getPatientEntity(Long id) {
        return patientEntityRepository.getById(id);
    }
}
