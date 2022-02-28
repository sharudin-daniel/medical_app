package com.example.medical_app.core.controller.rest;

import com.example.medical_app.core.model.entity.MedicalHistory;
import com.example.medical_app.core.model.entity.PatientEntity;
import com.example.medical_app.core.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("{id}")
    public ResponseEntity<PatientEntity> getPatient(@PathVariable("id") Long id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        PatientEntity patientEntity = this.patientService.getPatientEntity(id);
        if(patientEntity == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return  new ResponseEntity<>(patientEntity, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<PatientEntity>> getAllPatient(){
        List<PatientEntity> list = this.patientService.getAllPatientEntity();

        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PatientEntity> deletePatient(@PathVariable Long id){
        PatientEntity patientEntity = this.patientService.getPatientEntity(id);

        if (patientEntity == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.patientService.deletePatientEntity(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<PatientEntity> saveMedicalHistory(@RequestBody PatientEntity patientEntity){
        if(patientEntity == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.patientService.savePatientEntity(patientEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("")
    public  ResponseEntity<PatientEntity> updateMedicalHistory( @RequestBody PatientEntity patientEntity){
        if( patientEntity == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.patientService.savePatientEntity(patientEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
