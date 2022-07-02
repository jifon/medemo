package com.example.medemo.model;


import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "checklists")
@Getter
@Setter
public class CheckList {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(name ="time",nullable = false)
    private Time time;

    @Column(name ="date",nullable = false)
    private Date date;

    @OneToMany(mappedBy="checkList")
    private Set<Answer> answers;



}
