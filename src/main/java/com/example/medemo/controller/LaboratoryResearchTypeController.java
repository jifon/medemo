package com.example.medemo.controller;

import com.example.medemo.dto.LaboratoryResearchTypeDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.LaboratoryResearchTypeMapper;
import com.example.medemo.model.LaboratoryResearchType;
import com.example.medemo.service.LaboratoryResearchTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LaboratoryResearchTypeController {

    @Autowired
    private LaboratoryResearchTypeService laboratoryResearchTypeService;

    @GetMapping(value="/laboratoryResearchType")
    List<LaboratoryResearchTypeDto> getAll(){
        return laboratoryResearchTypeService.getAllLaboratoryResearchTypes();
    }

    @GetMapping(value="/laboratoryResearchType/{id}")
    ResponseEntity<LaboratoryResearchType> getById(@PathVariable("id") long id) {
        LaboratoryResearchType laboratoryResearchType = laboratoryResearchTypeService.findById(id)
                .orElseThrow(()->new NotFoundException("No LaboratoryResearchType with ID : "+id));
        return ResponseEntity.ok().body(laboratoryResearchType);
    }

    @PostMapping(value="/laboratoryResearchType")
    ResponseEntity<?> createLaboratoryResearchType(@RequestBody LaboratoryResearchTypeDto dto) {
        LaboratoryResearchType laboratoryResearchType = LaboratoryResearchTypeMapper.DtoToEntity(dto);
        LaboratoryResearchType addedEntity = laboratoryResearchTypeService.save(laboratoryResearchType);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedEntity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/laboratoryResearchType/{id}")
    ResponseEntity<LaboratoryResearchType> updateLaboratoryResearchType(@PathVariable("id") long id, @RequestBody LaboratoryResearchTypeDto dto) {
        LaboratoryResearchType laboratoryResearchType = laboratoryResearchTypeService.findById(id)
                .orElseThrow(()->new NotFoundException("No LaboratoryResearchType with ID : "+id));

        LaboratoryResearchType newEntity = LaboratoryResearchTypeMapper.DtoToEntity(dto);
        newEntity.setId(laboratoryResearchType.getId());
        laboratoryResearchTypeService.save(newEntity);
        return ResponseEntity.ok().body(newEntity);
    }

    @DeleteMapping(value="/laboratoryResearchType/{id}")
    ResponseEntity deleteLaboratoryResearchType( @PathVariable("id") long id) {
        LaboratoryResearchType laboratoryResearchType = laboratoryResearchTypeService.findById(id)
                .orElseThrow(()->new NotFoundException("No LaboratoryResearchType with ID : "+id));
        laboratoryResearchTypeService.delete(laboratoryResearchType.getId());
        return ResponseEntity.ok().body("LaboratoryResearchType with ID : "+id+" deleted with success!");
    }

}
