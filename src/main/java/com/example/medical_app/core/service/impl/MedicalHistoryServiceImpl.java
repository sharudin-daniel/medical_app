package com.example.medical_app.core.service.impl;

import com.example.medical_app.core.model.entity.MedicalHistory;
import com.example.medical_app.core.repository.MedicalHistoryRepository;
import com.example.medical_app.core.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {

    @Autowired
    MedicalHistoryRepository medicalHistoryRepository;

    @Override
    public List<MedicalHistory> getAllMedicalHistory() {
        return medicalHistoryRepository.findAll();
    }

    @Override
    public void saveMedicalHistory(MedicalHistory medicalHistory) {
        medicalHistoryRepository.save(medicalHistory);
    }

    @Override
    public void deleteMedicalHistory(Long id) {
        medicalHistoryRepository.deleteById(id);
    }

    @Override
    public MedicalHistory getMedicalHistory(Long id) {
        return medicalHistoryRepository.getById(id);
    }
}
