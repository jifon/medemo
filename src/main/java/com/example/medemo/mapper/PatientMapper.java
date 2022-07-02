package com.example.medemo.mapper;

import com.example.medemo.dto.PatientDto;
import com.example.medemo.model.Patient;

public class PatientMapper {

    public static Patient DtoToEntity(PatientDto dto) {

        Patient entity = new Patient();
        entity.setAge(dto.getAge());
        entity.setCitizenship(dto.getCitizenship());
        entity.setPIN(dto.getPIN());
        entity.setInsurance_territory(dto.getInsurance_territory());
        entity.setImage(dto.getImage());
        entity.setCategory(dto.getCategory());
        entity.setWorkplace(dto.getWorkplace());
        entity.setPosition(dto.getPosition());
        entity.setPhone_number(dto.getPhone_number());
        entity.setHusband_phone_number(dto.getHusband_phone_number());
        entity.setHusband_workplace(dto.getHusband_workplace());
        entity.setHusband_position(dto.getHusband_position());
        entity.setMarital_status(dto.getMarital_status());
        entity.setEducation(dto.getEducation());
        entity.setUser(dto.getUser());
        entity.setPregnancies(dto.getPregnancies());

        return entity;
    }
    public static PatientDto EntityToDto(Patient dto) {

        PatientDto entity = new PatientDto();
        dto.setAge(entity.getAge());
        dto.setCitizenship(entity.getCitizenship());
        dto.setPIN(entity.getPIN());
        dto.setInsurance_territory(entity.getInsurance_territory());
        dto.setImage(entity.getImage());
        dto.setCategory(entity.getCategory());
        dto.setWorkplace(entity.getWorkplace());
        dto.setPosition(entity.getPosition());
        dto.setPhone_number(entity.getPhone_number());
        dto.setHusband_phone_number(entity.getHusband_phone_number());
        dto.setHusband_workplace(entity.getHusband_workplace());
        dto.setHusband_position(entity.getHusband_position());
        dto.setMarital_status(entity.getMarital_status());
        dto.setEducation(entity.getEducation());
        dto.setUser(entity.getUser());
        dto.setPregnancies(entity.getPregnancies());

        return entity;
    }
}
