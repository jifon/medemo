package com.example.medemo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "laboratory_researches")
@Getter
@Setter
public class LaboratoryResearch {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lab_res_type_id", nullable = false)
    private LaboratoryResearch laboratoryResearch;

    @Column(name = "result", nullable = false)
    private String result;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "pregnancy_id", nullable = false)
    private Pregnancy pregnancy;

}
