package com.example.medemo.controller;

import com.example.medemo.dto.AppointmentTypeDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.AppointmentTypeMapper;
import com.example.medemo.model.AppointmentType;
import com.example.medemo.service.AppointmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppointmentTypeController {

    @Autowired
    private AppointmentTypeService appointmentTypeService;

    @GetMapping(value="/appointmentType")
    List<AppointmentType> getAll(){
        return appointmentTypeService.getAllAppointmentTypes();
    }

    @GetMapping(value="/appointmentType/{id}")
    ResponseEntity<AppointmentType> getById(@PathVariable("id") long id) {
        AppointmentType appointmentType = appointmentTypeService.findById(id)
                .orElseThrow(()->new NotFoundException("No AppointmentType with ID : "+id));
        return ResponseEntity.ok().body(appointmentType);
    }

    @PostMapping(value="/appointmentType")
    ResponseEntity<?> createAppointmentType(@RequestBody AppointmentTypeDto dto) {
        AppointmentType appointmentType = AppointmentTypeMapper.DtoToEntity(dto);
        AppointmentType addedAppointmentType = appointmentTypeService.save(appointmentType);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedAppointmentType.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/appointmentType/{id}")
    ResponseEntity<AppointmentType> updateAppointmentType(@PathVariable("id") long id, @RequestBody AppointmentTypeDto dto) {
        AppointmentType appointmentType = appointmentTypeService.findById(id)
                .orElseThrow(()->new NotFoundException("No AppointmentType with ID : "+id));

        AppointmentType newAppointmentType = AppointmentTypeMapper.DtoToEntity(dto);
        newAppointmentType.setId(appointmentType.getId());
        appointmentTypeService.save(newAppointmentType);
        return ResponseEntity.ok().body(newAppointmentType);
    }

    @DeleteMapping(value="/appointmentType/{id}")
    ResponseEntity deleteAppointmentType( @PathVariable("id") long id) {
        AppointmentType appointmentType = appointmentTypeService.findById(id)
                .orElseThrow(()->new NotFoundException("No AppointmentType with ID : "+id));
        appointmentTypeService.delete(appointmentType.getId());
        return ResponseEntity.ok().body("AppointmentType with ID : "+id+" deleted with success!");
    }
}
