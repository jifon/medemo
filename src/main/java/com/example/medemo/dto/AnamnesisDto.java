package com.example.medemo.dto;

import com.example.medemo.model.Disease;
import com.example.medemo.model.Pregnancy;
import lombok.Data;


@Data
public class AnamnesisDto {

//    private Long id;
    private Disease diseas;
    private Pregnancy pregnancy;
}
