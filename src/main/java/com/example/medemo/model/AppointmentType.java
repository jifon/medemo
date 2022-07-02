package com.example.medemo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "appointment_type")
@Getter
@Setter
public class AppointmentType {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy="appointment_type")
    private Set<Appointment> appointment_types;

    @ManyToOne
    @JoinColumn(name = "pregnancy_id", nullable = false)
    private Pregnancy pregnancy;
}
