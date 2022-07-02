package com.example.medemo.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.time.DayOfWeek;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "doctors_schedules")
@Getter
@Setter
public class DoctorSchedule {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name ="day_of_week",nullable = false)
    private DayOfWeek dayOfWeek;

    @Column(name ="time_start",nullable = false)
    private Time time_start;

    @Column(name ="time_end",nullable = false)
    private Time time_end;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;


}
