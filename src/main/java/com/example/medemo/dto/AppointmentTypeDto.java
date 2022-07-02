package com.example.medemo.dto;

import com.example.medemo.model.Appointment;
import com.example.medemo.model.Pregnancy;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
public class AppointmentTypeDto {

//    private Long id;
    private String name;
    private Set<Appointment> appointment_types;
    private Pregnancy pregnancy;
}
