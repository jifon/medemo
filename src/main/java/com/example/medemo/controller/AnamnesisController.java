package com.example.medemo.controller;

import com.example.medemo.dto.AnamnesisDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.AnamnesisMapper;
import com.example.medemo.model.Anamnesis;
import com.example.medemo.service.AnamnesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AnamnesisController {

    @Autowired
    private AnamnesisService anamnesisService;

    @GetMapping(value="/anamnesis")
    List<Anamnesis> getAll(){
        return anamnesisService.getAllAnamnesis();
    }

    @GetMapping(value="/anamnesis/{id}")
    ResponseEntity<Anamnesis> getById(@PathVariable("id") long id) {
        Anamnesis anamnesis = anamnesisService.findById(id)
                .orElseThrow(()->new NotFoundException("No anamnesis with ID : "+id));
        return ResponseEntity.ok().body(anamnesis);
    }

    @PostMapping(value="/anamnesis")
    ResponseEntity<?> createAnamnesis(@RequestBody AnamnesisDto dto) {
        Anamnesis anamnesis = AnamnesisMapper.DtoToEntity(dto);
        Anamnesis addedAnamnesis = anamnesisService.save(anamnesis);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedAnamnesis.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/anamnesis/{id}")
    ResponseEntity<Anamnesis> updateAnamnesis(@PathVariable("id") long id, @RequestBody AnamnesisDto dto) {
        Anamnesis anamnesis = anamnesisService.findById(id)
                .orElseThrow(()->new NotFoundException("No Anamnesis with ID : "+id));

        Anamnesis newAnamnesis = AnamnesisMapper.DtoToEntity(dto);
        newAnamnesis.setId(anamnesis.getId());
        anamnesisService.save(newAnamnesis);
        return ResponseEntity.ok().body(newAnamnesis);
    }

    @DeleteMapping(value="/anamnesis/{id}")
    ResponseEntity deleteAnamnesis( @PathVariable("id") long id) {
        Anamnesis anamnesis = anamnesisService.findById(id)
                .orElseThrow(()->new NotFoundException("No Anamnesis with ID : "+id));
        anamnesisService.delete(anamnesis.getId());
        return ResponseEntity.ok().body("Anamnesis with ID : "+id+" deleted with success!");
    }



}
