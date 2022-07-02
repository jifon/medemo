package com.example.medemo.dto;

import com.example.medemo.model.Doctor;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.time.DayOfWeek;

@Data
public class DoctorScheduleDto {

//    private Long id;
    private DayOfWeek dayOfWeek;
    private Time time_start;
    private Time time_end;
    private Doctor doctor;


}
