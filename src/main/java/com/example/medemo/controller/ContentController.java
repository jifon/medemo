package com.example.medemo.controller;

import com.example.medemo.dto.ContentDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.ContentMapper;
import com.example.medemo.model.Content;
import com.example.medemo.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping(value="/content")
    List<Content> getAll(){
        return contentService.getAllContents();
    }

    @GetMapping(value="/content/{id}")
    ResponseEntity<Content> getById(@PathVariable("id") long id) {
        Content content = contentService.findById(id)
                .orElseThrow(()->new NotFoundException("No content with ID : "+id));
        return ResponseEntity.ok().body(content);
    }

    @PostMapping(value="/content")
    ResponseEntity<?> createContent(@RequestBody ContentDto dto) {
        Content content = ContentMapper.DtoToEntity(dto);
        Content addedContent = contentService.save(content);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedContent.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/content/{id}")
    ResponseEntity<Content> updateContent(@PathVariable("id") long id, @RequestBody ContentDto dto) {
        Content content = contentService.findById(id)
                .orElseThrow(()->new NotFoundException("No content with ID : "+id));

        Content newContent = ContentMapper.DtoToEntity(dto);
        newContent.setId(content.getId());
        contentService.save(newContent);
        return ResponseEntity.ok().body(newContent);
    }

    @DeleteMapping(value="/content/{id}")
    ResponseEntity deleteContent( @PathVariable("id") long id) {
        Content content = contentService.findById(id)
                .orElseThrow(()->new NotFoundException("No content with ID : "+id));
        contentService.delete(content.getId());
        return ResponseEntity.ok().body("Content with ID : "+id+" deleted with success!");
    }
}
