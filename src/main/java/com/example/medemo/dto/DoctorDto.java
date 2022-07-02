package com.example.medemo.dto;

import com.example.medemo.model.CheckList;
import com.example.medemo.model.DoctorSchedule;
import com.example.medemo.model.Pregnancy;
import com.example.medemo.model.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
public class DoctorDto {

//    private Long id;
    private int age;
    private User user;
    private Set<DoctorSchedule> schedules;
    private Set<Pregnancy> pregnancies;
    private Set<CheckList> checkLists;

}
