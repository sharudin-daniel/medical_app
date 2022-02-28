package com.example.medical_app.core.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "patients")
public class PatientEntity {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    String name;

    @Column(name = "gender")
    Gender gender;

    @Column(name = "age")
    int age;

    @Column(name = "city")
    String city;

    @Column(name = "address")
    String address;

    @Column(name = "birthdayDt")
    Date birthdayDt;

    @Column(name = "birthPlace")
    String birthPlace;

    @Column(name = "registration")
    String registration;

    @Column(name = "passportSeries")
    int passportSeries;

    @Column(name = "passportNumber")
    int passportNumber;

    @Column(name = "phoneNumber")
    String phoneNumber;

    @Column(name = "anotherDocument")
    String anotherDocument; //Какой документ? Просто тип (водительские права и т.п. - enum) или  отдельный объект?

}

enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE");

    private String value;

    Gender(String value) {
        this.value = value;
    }
    public String toString() {
        return value;
    }
}
