package com.example.medemo.controller;

import com.example.medemo.dto.DiseaseTypeDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.DiseaseTypeMapper;
import com.example.medemo.model.DiseaseType;
import com.example.medemo.service.DiseaseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DiseaseTypeController {


    @Autowired
    private DiseaseTypeService diseaseTypeService;

    @GetMapping(value="/diseaseType")
    List<DiseaseType> getAll(){
        return diseaseTypeService.getAllDiseaseTypes();
    }

    @GetMapping(value="/diseaseType/{id}")
    ResponseEntity<DiseaseType> getById(@PathVariable("id") long id) {
        DiseaseType diseaseType = diseaseTypeService.findById(id)
                .orElseThrow(()->new NotFoundException("No disease type with ID : "+id));
        return ResponseEntity.ok().body(diseaseType);
    }

    @PostMapping(value="/diseaseType")
    ResponseEntity<?> createDiseaseType(@RequestBody DiseaseTypeDto dto) {
        DiseaseType diseaseType = DiseaseTypeMapper.DtoToEntity(dto);
        DiseaseType addedDiseaseType = diseaseTypeService.save(diseaseType);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedDiseaseType.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/diseaseType/{id}")
    ResponseEntity<DiseaseType> updateDiseaseType(@PathVariable("id") long id, @RequestBody DiseaseTypeDto dto) {
        DiseaseType diseaseType = diseaseTypeService.findById(id)
                .orElseThrow(()->new NotFoundException("No disease type with ID : "+id));

        DiseaseType newDiseaseType = DiseaseTypeMapper.DtoToEntity(dto);
        newDiseaseType.setId(diseaseType.getId());
        diseaseTypeService.save(newDiseaseType);
        return ResponseEntity.ok().body(newDiseaseType);
    }

    @DeleteMapping(value="/diseaseType/{id}")
    ResponseEntity deleteDiseaseType( @PathVariable("id") long id) {
        DiseaseType diseaseType = diseaseTypeService.findById(id)
                .orElseThrow(()->new NotFoundException("No disease type with ID : "+id));
        diseaseTypeService.delete(diseaseType.getId());
        return ResponseEntity.ok().body("Disease type with ID : "+id+" deleted with success!");
    }


}
