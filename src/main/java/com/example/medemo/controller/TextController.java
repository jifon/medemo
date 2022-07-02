package com.example.medemo.controller;

import com.example.medemo.dto.TextDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.TextMapper;
import com.example.medemo.model.Text;
import com.example.medemo.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/t")
public class TextController {

    @Autowired
    private TextService textService;


    @GetMapping(value="/texts")
    List<TextDto> getAll(){
        return textService.getAllProducts();
    }


    @GetMapping(value="/texts/{id}")
    ResponseEntity<TextDto> getById(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(textService.findById(id).get());
    }


    @PostMapping(value="/texts")
    ResponseEntity<TextDto> createText(@RequestBody TextDto dto) {
        return ResponseEntity.ok().body(textService.save(dto));
    }


    @PutMapping(value="/texts/{id}")
    ResponseEntity<TextDto> updateText(@PathVariable("id") long id, @RequestBody TextDto dto) {
        return ResponseEntity.ok().body(textService.update(id, dto));
    }


    @DeleteMapping(value="/texts/{id}")
    ResponseEntity<Void> deleteText( @PathVariable("id") long id) {
        textService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
