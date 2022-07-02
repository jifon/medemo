package com.example.medemo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "laboratory_research_type")
@Getter
@Setter
public class LaboratoryResearchType {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="pregnancy")
    private Set<LaboratoryResearch> laboratoryResearches;





}
