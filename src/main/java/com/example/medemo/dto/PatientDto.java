package com.example.medemo.dto;

import com.example.medemo.model.Pregnancy;
import com.example.medemo.model.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
public class PatientDto {

//    private Long id;
    private int age;
    private String citizenship;
    private int PIN;
    private String insurance_territory;
    private String image;
    private String category;
    private String workplace;
    private String position;
    private int phone_number;
    private int husband_phone_number;
    private String husband_workplace;
    private String husband_position;
    private String marital_status;
    private String education;
    private User user;
    private Set<Pregnancy> pregnancies;


}
