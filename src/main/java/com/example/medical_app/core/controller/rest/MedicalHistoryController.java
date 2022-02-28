package com.example.medical_app.core.controller.rest;

import com.example.medical_app.core.model.entity.MedicalHistory;
import com.example.medical_app.core.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical/medicalHistory")
public class MedicalHistoryController {
    @Autowired
    MedicalHistoryService medicalHistoryService;

    @GetMapping("{id}")
    public ResponseEntity<MedicalHistory> getMedicalHistory(@PathVariable("id") Long id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        MedicalHistory medicalHistory = this.medicalHistoryService.getMedicalHistory(id);
        if(medicalHistory == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return  new ResponseEntity<>(medicalHistory, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<MedicalHistory>> getAllMedicalHistory(){
        List<MedicalHistory> list = this.medicalHistoryService.getAllMedicalHistory();

        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MedicalHistory> deleteMedicalHistory(@PathVariable Long id){
        MedicalHistory medicalHistory = this.medicalHistoryService.getMedicalHistory(id);

        if (medicalHistory == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.medicalHistoryService.deleteMedicalHistory(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<MedicalHistory> saveMedicalHistory(@RequestBody MedicalHistory medicalHistory){
        if(medicalHistory == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.medicalHistoryService.saveMedicalHistory(medicalHistory);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("")
    public  ResponseEntity<MedicalHistory> updateMedicalHistory( @RequestBody MedicalHistory medicalHistory){
        if( medicalHistory == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.medicalHistoryService.saveMedicalHistory(medicalHistory);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
