package com.example.medemo.controller;

import com.example.medemo.dto.DoctorScheduleDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.DoctorScheduleMapper;
import com.example.medemo.model.DoctorSchedule;
import com.example.medemo.service.DoctorScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorScheduleController {

    @Autowired
    private DoctorScheduleService doctorScheduleService;

    @GetMapping(value="/doctorSchedule")
    List<DoctorScheduleDto> getAll(){
        return doctorScheduleService.getAllDoctorSchedules();
    }

    @GetMapping(value="/doctorSchedule/{id}")
    ResponseEntity<DoctorSchedule> getById(@PathVariable("id") long id) {
        DoctorSchedule doctorSchedule = doctorScheduleService.findById(id)
                .orElseThrow(()->new NotFoundException("No doctorSchedule with ID : "+id));
        return ResponseEntity.ok().body(doctorSchedule);
    }

    @PostMapping(value="/doctorSchedule")
    ResponseEntity<?> createDoctorSchedule(@RequestBody DoctorScheduleDto dto) {
        DoctorSchedule doctorSchedule = DoctorScheduleMapper.DtoToEntity(dto);
        DoctorSchedule addedDoctorSchedule = doctorScheduleService.save(doctorSchedule);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedDoctorSchedule.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/DoctorSchedule/{id}")
    ResponseEntity<DoctorSchedule> updateDoctorSchedule(@PathVariable("id") long id, @RequestBody DoctorScheduleDto dto) {
        DoctorSchedule doctorSchedule = doctorScheduleService.findById(id)
                .orElseThrow(()->new NotFoundException("No doctorSchedule with ID : "+id));

        DoctorSchedule newDoctorSchedule = DoctorScheduleMapper.DtoToEntity(dto);
        newDoctorSchedule.setId(doctorSchedule.getId());
        doctorScheduleService.save(newDoctorSchedule);
        return ResponseEntity.ok().body(newDoctorSchedule);
    }

    @DeleteMapping(value="/doctorSchedule/{id}")
    ResponseEntity deleteDoctorSchedule( @PathVariable("id") long id) {
        DoctorSchedule doctorSchedule = doctorScheduleService.findById(id)
                .orElseThrow(()->new NotFoundException("No doctorSchedule with ID : "+id));
        doctorScheduleService.delete(doctorSchedule.getId());
        return ResponseEntity.ok().body("DoctorSchedule with ID : "+id+" deleted with success!");
    }

}
