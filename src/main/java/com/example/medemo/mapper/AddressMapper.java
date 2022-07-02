package com.example.medemo.mapper;

import com.example.medemo.dto.AddressDto;
import com.example.medemo.dto.TextDto;
import com.example.medemo.model.Address;
import com.example.medemo.model.Text;

public class AddressMapper {

    public static Address DtoToEntity(AddressDto dto) {

        Address entity = new Address();
        entity.setCity(dto.getCity());
        entity.setVillage(dto.getVillage());
        entity.setStreet_name(dto.getStreet_name());
        entity.setHouse_number(dto.getHouse_number());
        entity.setPhone_number(dto.getPhone_number());
        entity.setRelative_city(dto.getRelative_city());
        entity.setRelative_village(dto.getRelative_village());
        entity.setRelative_house_number(dto.getRelative_house_number());
        entity.setRelative_phone_number(dto.getRelative_phone_number());
        entity.setPatient(dto.getPatient());

        return entity;
    }
    public static AddressDto EntityToDto(Address entity) {

        AddressDto dto = new AddressDto();

        dto.setCity(entity.getCity());
        dto.setVillage(entity.getVillage());
        dto.setStreet_name(entity.getStreet_name());
        dto.setHouse_number(entity.getHouse_number());
        dto.setPhone_number(entity.getPhone_number());
        dto.setRelative_city(entity.getRelative_city());
        dto.setRelative_village(entity.getRelative_village());
        dto.setRelative_house_number(entity.getRelative_house_number());
        dto.setRelative_phone_number(entity.getRelative_phone_number());
        dto.setPatient(entity.getPatient());

        return dto;
    }
}
