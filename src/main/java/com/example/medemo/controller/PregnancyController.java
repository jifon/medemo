package com.example.medemo.controller;

import com.example.medemo.dto.PregnancyDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.PregnancyMapper;
import com.example.medemo.model.Pregnancy;
import com.example.medemo.service.PregnancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PregnancyController {


    @Autowired
    private PregnancyService pregnancyService;

    @GetMapping(value="/pregnancy")
    List<PregnancyDto> getAll(){
        return pregnancyService.getAllPregnancies();
    }

    @GetMapping(value="/pregnancy/{id}")
    ResponseEntity<Pregnancy> getById(@PathVariable("id") long id) {
        Pregnancy pregnancy = pregnancyService.findById(id)
                .orElseThrow(()->new NotFoundException("No pregnancy with ID : "+id));
        return ResponseEntity.ok().body(pregnancy);
    }

    @PostMapping(value="/pregnancy")
    ResponseEntity<?> createPregnancy(@RequestBody PregnancyDto dto) {
        Pregnancy pregnancy = PregnancyMapper.DtoToEntity(dto);
        Pregnancy addedPregnancy = pregnancyService.save(pregnancy);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedPregnancy.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/pregnancy/{id}")
    ResponseEntity<Pregnancy> updatePregnancy(@PathVariable("id") long id, @RequestBody PregnancyDto dto) {
        Pregnancy pregnancy = pregnancyService.findById(id)
                .orElseThrow(()->new NotFoundException("No pregnancy with ID : "+id));

        Pregnancy newPregnancy = PregnancyMapper.DtoToEntity(dto);
        newPregnancy.setId(pregnancy.getId());
        pregnancyService.save(newPregnancy);
        return ResponseEntity.ok().body(newPregnancy);
    }

    @DeleteMapping(value="/pregnancy/{id}")
    ResponseEntity deletePregnancy( @PathVariable("id") long id) {
        Pregnancy pregnancy = pregnancyService.findById(id)
                .orElseThrow(()->new NotFoundException("No pregnancy with ID : "+id));
        pregnancyService.delete(pregnancy.getId());
        return ResponseEntity.ok().body("Pregnancy with ID : "+id+" deleted with success!");
    }

}
