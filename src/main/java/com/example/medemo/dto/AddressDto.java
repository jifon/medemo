package com.example.medemo.dto;

import com.example.medemo.model.Patient;
import lombok.Data;

import javax.persistence.*;

@Data
public class AddressDto {

//    private Long id;
    private String city;
    private String village;
    private String street_name;
    private int house_number;
    private int phone_number;
    private String relative_city;
    private String relative_village;
    private int relative_house_number;
    private int relative_phone_number;
    private Patient patient;
}
