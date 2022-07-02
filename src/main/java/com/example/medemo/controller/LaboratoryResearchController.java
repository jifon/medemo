package com.example.medemo.controller;

import com.example.medemo.dto.LaboratoryResearchDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.LaboratoryResearchMapper;
import com.example.medemo.model.LaboratoryResearch;
import com.example.medemo.service.LaboratoryResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LaboratoryResearchController {

    @Autowired
    private LaboratoryResearchService laboratoryResearchService;

    @GetMapping(value="/laboratoryResearch")
    List<LaboratoryResearchDto> getAll(){
        return laboratoryResearchService.getAllLaboratoryResearches();
    }

    @GetMapping(value="/laboratoryResearch/{id}")
    ResponseEntity<LaboratoryResearch> getById(@PathVariable("id") long id) {
        LaboratoryResearch laboratoryResearch = laboratoryResearchService.findById(id)
                .orElseThrow(()->new NotFoundException("No laboratoryResearch with ID : "+id));
        return ResponseEntity.ok().body(laboratoryResearch);
    }

    @PostMapping(value="/laboratoryResearch")
    ResponseEntity<?> createLaboratoryResearch(@RequestBody LaboratoryResearchDto dto) {
        LaboratoryResearch laboratoryResearch = LaboratoryResearchMapper.DtoToEntity(dto);
        LaboratoryResearch addedLaboratoryResearch = laboratoryResearchService.save(laboratoryResearch);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedLaboratoryResearch.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/laboratoryResearch/{id}")
    ResponseEntity<LaboratoryResearch> updateLaboratoryResearch(@PathVariable("id") long id, @RequestBody LaboratoryResearchDto dto) {
        LaboratoryResearch laboratoryResearch = laboratoryResearchService.findById(id)
                .orElseThrow(()->new NotFoundException("No laboratoryResearch with ID : "+id));
        LaboratoryResearch newLaboratoryResearch = LaboratoryResearchMapper.DtoToEntity(dto);
        newLaboratoryResearch.setId(laboratoryResearch.getId());
        laboratoryResearchService.save(newLaboratoryResearch);
        return ResponseEntity.ok().body(newLaboratoryResearch);
    }

    @DeleteMapping(value="/laboratoryResearch/{id}")
    ResponseEntity deleteLaboratoryResearch( @PathVariable("id") long id) {
        LaboratoryResearch laboratoryResearch = laboratoryResearchService.findById(id)
                .orElseThrow(()->new NotFoundException("No LaboratoryResearch with ID : "+id));
        laboratoryResearchService.delete(laboratoryResearch.getId());
        return ResponseEntity.ok().body("LaboratoryResearch with ID : "+id+" deleted with success!");
    }
}
