package com.example.medemo.controller;

import com.example.medemo.dto.PatientDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.PatientMapper;
import com.example.medemo.model.Patient;
import com.example.medemo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(value="/patient")
    List<PatientDto> getAll(){
        return patientService.getAllPatients();
    }

    @GetMapping(value="/patient/{id}")
    ResponseEntity<Patient> getById(@PathVariable("id") long id) {
        Patient patient = patientService.findById(id)
                .orElseThrow(()->new NotFoundException("No patient with ID : "+id));
        return ResponseEntity.ok().body(patient);
    }

    @PostMapping(value="/patient")
    ResponseEntity<?> createPatient(@RequestBody PatientDto dto) {
        Patient patient = PatientMapper.DtoToEntity(dto);
        Patient addedPatient = patientService.save(patient);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedPatient.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/patient/{id}")
    ResponseEntity<Patient> updatePatient(@PathVariable("id") long id, @RequestBody PatientDto dto) {
        Patient patient = patientService.findById(id)
                .orElseThrow(()->new NotFoundException("No patient with ID : "+id));

        Patient newPatient = PatientMapper.DtoToEntity(dto);
        newPatient.setId(patient.getId());
        patientService.save(newPatient);
        return ResponseEntity.ok().body(newPatient);
    }

    @DeleteMapping(value="/patient/{id}")
    ResponseEntity deletePatient( @PathVariable("id") long id) {
        Patient patient = patientService.findById(id)
                .orElseThrow(()->new NotFoundException("No patient with ID : "+id));
        patientService.delete(patient.getId());
        return ResponseEntity.ok().body("Patient with ID : "+id+" deleted with success!");
    }
}
