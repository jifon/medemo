package com.example.medemo.dto;

import com.example.medemo.model.LaboratoryResearch;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
public class LaboratoryResearchTypeDto {

//    private Long id;
    private String name;
    private Set<LaboratoryResearch> laboratoryResearches;


}
