package com.example.medical_app.core.service;

import com.example.medical_app.core.model.entity.MedicalHistory;

import java.util.List;

public interface MedicalHistoryService {
    List<MedicalHistory> getAllMedicalHistory();
    void saveMedicalHistory(MedicalHistory medicalHistory);
    void deleteMedicalHistory(Long id);
    MedicalHistory getMedicalHistory(Long id);
}
