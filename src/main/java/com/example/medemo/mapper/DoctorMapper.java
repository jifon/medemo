package com.example.medemo.mapper;

import com.example.medemo.dto.DoctorDto;
import com.example.medemo.model.Doctor;

public class DoctorMapper {
    public static Doctor DtoToEntity(DoctorDto dto) {

        Doctor entity = new Doctor();

        entity.setAge(dto.getAge());
        entity.setUser(dto.getUser());
        entity.setSchedules(dto.getSchedules());
        entity.setPregnancies(dto.getPregnancies());
        entity.setCheckLists(dto.getCheckLists());


        return entity;
    }
    public static DoctorDto EntityToDto(Doctor entity) {

        DoctorDto dto = new DoctorDto();

        dto.setAge(entity.getAge());
        dto.setUser(entity.getUser());
        entity.setSchedules(dto.getSchedules());
        entity.setPregnancies(dto.getPregnancies());
        entity.setCheckLists(dto.getCheckLists());

        return dto;
    }
}
