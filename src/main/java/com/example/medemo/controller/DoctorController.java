package com.example.medemo.controller;

import com.example.medemo.dto.DoctorDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.DoctorMapper;
import com.example.medemo.model.Doctor;
import com.example.medemo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value="/doctor")
    List<Doctor> getAll(){
        return doctorService.getAllDoctors();
    }

    @GetMapping(value="/doctor/{id}")
    ResponseEntity<Doctor> getById(@PathVariable("id") long id) {
        Doctor doctor = doctorService.findById(id)
                .orElseThrow(()->new NotFoundException("No doctor with ID : "+id));
        return ResponseEntity.ok().body(doctor);
    }

    @PostMapping(value="/doctor")
    ResponseEntity<?> createDoctor(@RequestBody DoctorDto dto) {
        Doctor doctor = DoctorMapper.DtoToEntity(dto);
        Doctor addedDoctor = doctorService.save(doctor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedDoctor.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/doctor/{id}")
    ResponseEntity<Doctor> updateText(@PathVariable("id") long id, @RequestBody DoctorDto dto) {
        Doctor doctor = doctorService.findById(id)
                .orElseThrow(()->new NotFoundException("No doctor with ID : "+id));

        Doctor newDoctor = DoctorMapper.DtoToEntity(dto);
        newDoctor.setId(doctor.getId());
        doctorService.save(newDoctor);
        return ResponseEntity.ok().body(newDoctor);
    }

    @DeleteMapping(value="/doctor/{id}")
    ResponseEntity deleteDoctor( @PathVariable("id") long id) {
        Doctor doctor = doctorService.findById(id)
                .orElseThrow(()->new NotFoundException("No doctor with ID : "+id));
        doctorService.delete(doctor.getId());
        return ResponseEntity.ok().body("Doctor with ID : "+id+" deleted with success!");
    }
}
