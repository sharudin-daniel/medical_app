package com.example.medical_app.core.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "medicalHistory")
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @OneToOne
    @JoinColumn(name = "patient_id", nullable = false)
    PatientEntity patient;

    @Column(name = "docNubmer")
    Long docNubmer;

    @Column(name = "createDttm")
    Date createDttm;

    @Column(name = "modifyDttm")
    Date modifyDttm;

    @Column(name = "doctor")
    String doctor; //(Пока ФИО, хотя по идее отдельная сущность)

    @Column(name = "diagnosis")
    String diagnosis; //(Пока название, хотя по идее отдельная сущность)


    //Связывающая таблица: medicalHistory.id  -  prevMedicalHistory
    @OneToMany
    @JoinColumn(name = "medicalHistory", nullable = false)
    List<MedicalHistory> medicalHistory;

}
