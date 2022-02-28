package com.example.medical_app.core.repository;

import com.example.medical_app.core.model.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientEntityRepository extends JpaRepository<PatientEntity, Long> {
}
