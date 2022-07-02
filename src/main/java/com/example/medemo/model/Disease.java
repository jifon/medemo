package com.example.medemo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "diseases")
@Getter
@Setter
public class Disease {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy="diseas")
    private Set<Anamnesis> anamnesis;

    @ManyToOne
    @JoinColumn(name = "disease_type_id", nullable = false)
    private DiseaseType disease_type;


}
