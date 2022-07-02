package com.example.medemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column(name ="age",nullable = false)
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "doctor")
    private Set<DoctorSchedule> schedules;

    @OneToMany(mappedBy = "doctrs")
    private Set<Pregnancy> pregnancies;

    @OneToMany(mappedBy="doctor")
    private Set<CheckList> checkLists;

}
