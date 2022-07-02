package com.example.medemo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "disease_types")
@Getter
@Setter
public class DiseaseType {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy="disease_type")
    private Set<Disease> diseas;


}
