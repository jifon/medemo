package com.example.medemo.controller;

import com.example.medemo.dto.AppointmentDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.AppointmentMapper;
import com.example.medemo.model.Appointment;
import com.example.medemo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppointmentController {


    @Autowired
    private AppointmentService appointmentService;

    @GetMapping(value="/appointment")
    List<Appointment> getAll(){
        return appointmentService.getAllAppointments();
    }

    @GetMapping(value="/appointment/{id}")
    ResponseEntity<Appointment> getById(@PathVariable("id") long id) {
        Appointment appointment = appointmentService.findById(id)
                .orElseThrow(()->new NotFoundException("No appointment with ID : "+id));
        return ResponseEntity.ok().body(appointment);
    }

    @PostMapping(value="/appointment")
    ResponseEntity<?> createAppointment(@RequestBody AppointmentDto dto) {
        Appointment appointment = AppointmentMapper.DtoToEntity(dto);
        Appointment addedAppointment = appointmentService.save(appointment);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedAppointment.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/appointment/{id}")

    ResponseEntity<Appointment> updateAppointment(@PathVariable("id") long id, @RequestBody AppointmentDto dto) {
        Appointment appointment = appointmentService.findById(id)
                .orElseThrow(()->new NotFoundException("No Appointment with ID : "+id));

        Appointment newAppointment = AppointmentMapper.DtoToEntity(dto);
        newAppointment.setId(appointment.getId());
        appointmentService.save(newAppointment);
        return ResponseEntity.ok().body(newAppointment);
    }

    @DeleteMapping(value="/appointment/{id}")
    ResponseEntity deleteAppointment( @PathVariable("id") long id) {
        Appointment appointment = appointmentService.findById(id)
                .orElseThrow(()->new NotFoundException("No appointment with ID : "+id));
        appointmentService.delete(appointment.getId());
        return ResponseEntity.ok().body("Appointment with ID : "+id+" deleted with success!");
    }

}
