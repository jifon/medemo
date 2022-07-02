package com.example.medemo.controller;

import com.example.medemo.dto.TextDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.TextMapper;
import com.example.medemo.model.Text;
import com.example.medemo.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TextController {

    @Autowired
    private TextService textService;

    @GetMapping(value="/texts")
    List<Text> getAll(){
        return textService.getAllProducts();
    }

    @GetMapping(value="/texts/{id}")
    ResponseEntity<Text> getById(@PathVariable("id") long id) {
        Text text = textService.findById(id)
                .orElseThrow(()->new NotFoundException("No text with ID : "+id));
        return ResponseEntity.ok().body(text);
    }

    @PostMapping(value="/texts")
    ResponseEntity<URI> createText(@RequestBody TextDto dto) {
        Text text = TextMapper.DtoToEntity(dto);
        Text addedtext = textService.save(text);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedtext.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/texts/{id}")
    ResponseEntity<Text> updateText(@PathVariable("id") long id, @RequestBody TextDto dto) {
        Text text = textService.findById(id)
                .orElseThrow(()->new NotFoundException("No text with ID : "+id));

        Text newText = TextMapper.DtoToEntity(dto);
        newText.setId(text.getId());
        textService.save(newText);
        return ResponseEntity.ok().body(newText);
    }

    @DeleteMapping(value="/texts/{id}")
    ResponseEntity deleteText( @PathVariable("id") long id) {
        Text text = textService.findById(id)
                .orElseThrow(()->new NotFoundException("No text with ID : "+id));
        textService.delete(text.getId());
        return ResponseEntity.ok().body("Text with ID : "+id+" deleted with success!");
    }

}
