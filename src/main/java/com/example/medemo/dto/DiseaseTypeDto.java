package com.example.medemo.dto;

import com.example.medemo.model.Disease;
import lombok.Data;

import java.util.Set;

@Data
public class DiseaseTypeDto {

//    private Long id;
    private String name;
    private Set<Disease> diseas;

}
