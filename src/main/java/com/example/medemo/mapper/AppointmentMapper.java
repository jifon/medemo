package com.example.medemo.mapper;

import com.example.medemo.dto.AppointmentDto;
import com.example.medemo.dto.TextDto;
import com.example.medemo.model.Appointment;
import com.example.medemo.model.Text;

public class AppointmentMapper {

    public static Appointment DtoToEntity(AppointmentDto dto) {

        Appointment entity = new Appointment();
        entity.setAppointment_type(dto.getAppointment_type());
        entity.setPregnancy(dto.getPregnancy());
        return entity;
    }
    public static AppointmentDto EntityToDto(Appointment entity) {

        AppointmentDto dto = new AppointmentDto();
        dto.setAppointment_type(entity.getAppointment_type());
        dto.setPregnancy(entity.getPregnancy());
        return dto;
    }
}
