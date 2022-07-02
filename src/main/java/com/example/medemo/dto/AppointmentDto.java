package com.example.medemo.dto;

import com.example.medemo.model.AppointmentType;
import com.example.medemo.model.Pregnancy;
import lombok.Data;

import javax.persistence.*;

@Data
public class AppointmentDto {

//    private Long id;
    private AppointmentType appointment_type;
    private Pregnancy pregnancy;
}
