package com.example.medemo.dto;

import com.example.medemo.model.Answer;
import com.example.medemo.model.Doctor;
import com.example.medemo.model.Patient;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Data
public class CheckListDto {

//    private Long id;
    private Patient patient;
    private Doctor doctor;
    private Time time;
    private Date date;
    private Set<Answer> answers;
}
