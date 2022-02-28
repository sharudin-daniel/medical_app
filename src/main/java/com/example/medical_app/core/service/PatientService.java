package com.example.medical_app.core.service;

import com.example.medical_app.core.model.entity.PatientEntity;

import java.util.List;

public interface PatientService {
    List<PatientEntity> getAllPatientEntity();
    void savePatientEntity(PatientEntity patientEntity);
    void deletePatientEntity(Long id);
    PatientEntity getPatientEntity(Long id);
}
