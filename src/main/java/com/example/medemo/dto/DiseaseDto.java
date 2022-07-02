package com.example.medemo.dto;

import com.example.medemo.model.Anamnesis;
import com.example.medemo.model.DiseaseType;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
public class DiseaseDto {

//    private Long id;
    private String name;
    private Set<Anamnesis> anamnesis;
    private DiseaseType disease_type;


}
