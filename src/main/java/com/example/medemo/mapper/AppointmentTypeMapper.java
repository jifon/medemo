package com.example.medemo.mapper;

import com.example.medemo.dto.AppointmentTypeDto;
import com.example.medemo.model.AppointmentType;

public class AppointmentTypeMapper {

    public static AppointmentType DtoToEntity(AppointmentTypeDto dto) {

        AppointmentType entity = new AppointmentType();
        entity.setName(dto.getName());
        entity.setAppointment_types(dto.getAppointment_types());
        entity.setPregnancy(dto.getPregnancy());

        return entity;
    }
    public static AppointmentTypeDto EntityToDto(AppointmentType entity) {

        AppointmentTypeDto dto = new AppointmentTypeDto();
        dto.setName(entity.getName());
        dto.setAppointment_types(entity.getAppointment_types());
        entity.setPregnancy(dto.getPregnancy());

        return dto;
    }
}
