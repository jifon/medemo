package com.example.medemo.controller;

import com.example.medemo.dto.DiseaseDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.DiseaseMapper;
import com.example.medemo.model.Disease;
import com.example.medemo.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    @GetMapping(value="/disease")
    List<Disease> getAll(){
        return diseaseService.getAllDiseases();
    }

    @GetMapping(value="/disease/{id}")
    ResponseEntity<Disease> getById(@PathVariable("id") long id) {
        Disease disease = diseaseService.findById(id)
                .orElseThrow(()->new NotFoundException("No disease with ID : "+id));
        return ResponseEntity.ok().body(disease);
    }

    @PostMapping(value="/disease")
    ResponseEntity<?> createDisease(@RequestBody DiseaseDto dto) {
        Disease disease = DiseaseMapper.DtoToEntity(dto);
        Disease addedDisease = diseaseService.save(disease);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedDisease.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/disease/{id}")
    ResponseEntity<Disease> updateDisease(@PathVariable("id") long id, @RequestBody DiseaseDto dto) {
        Disease disease = diseaseService.findById(id)
                .orElseThrow(()->new NotFoundException("No disease with ID : "+id));

        Disease newDisease = DiseaseMapper.DtoToEntity(dto);
        newDisease.setId(disease.getId());
        diseaseService.save(newDisease);
        return ResponseEntity.ok().body(newDisease);
    }

    @DeleteMapping(value="/disease/{id}")
    ResponseEntity deleteDisease( @PathVariable("id") long id) {
        Disease disease = diseaseService.findById(id)
                .orElseThrow(()->new NotFoundException("No disease with ID : "+id));
        diseaseService.delete(disease.getId());
        return ResponseEntity.ok().body("Disease with ID : "+id+" deleted with success!");
    }
}
