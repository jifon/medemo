package com.example.medemo.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "appointments")
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @ManyToOne
    @JoinColumn(name = "appointment_type_id", nullable = false)
    private AppointmentType appointment_type;
    @ManyToOne
    @JoinColumn(name = "pregnancy_id", nullable = false)
    private Pregnancy pregnancy;
}
