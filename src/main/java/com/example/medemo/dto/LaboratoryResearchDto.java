package com.example.medemo.dto;

import com.example.medemo.model.LaboratoryResearch;
import com.example.medemo.model.Pregnancy;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class LaboratoryResearchDto {

//    private Long id;
    private LaboratoryResearch laboratoryResearch;
    private String result;
    private Date date;
    private Pregnancy pregnancy;

}
