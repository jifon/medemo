package com.example.medemo.controller;

import com.example.medemo.dto.QuestionDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.QuestionMapper;
import com.example.medemo.model.Question;
import com.example.medemo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping(value="/question")
    List<QuestionDto> getAll(){
        return questionService.getAllQuestion();
    }

    @GetMapping(value="/question/{id}")
    ResponseEntity<Question> getById(@PathVariable("id") long id) {
        Question question = questionService.findById(id)
                .orElseThrow(()->new NotFoundException("No Question with ID : "+id));
        return ResponseEntity.ok().body(question);
    }

    @PostMapping(value="/question")
    ResponseEntity<?> createQuestion(@RequestBody QuestionDto dto) {
        Question question = QuestionMapper.DtoToEntity(dto);
        Question addedQuestion = questionService.save(question);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedQuestion.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/question/{id}")
    ResponseEntity<Question> updateQuestion(@PathVariable("id") long id, @RequestBody QuestionDto dto) {
        Question question = questionService.findById(id)
                .orElseThrow(()->new NotFoundException("No Question with ID : "+id));

        Question newQuestion = QuestionMapper.DtoToEntity(dto);
        newQuestion.setId(question.getId());
        questionService.save(newQuestion);
        return ResponseEntity.ok().body(newQuestion);
    }

    @DeleteMapping(value="/question/{id}")
    ResponseEntity deleteQuestion( @PathVariable("id") long id) {
        Question question = questionService.findById(id)
                .orElseThrow(()->new NotFoundException("No Question with ID : "+id));
        questionService.delete(question.getId());
        return ResponseEntity.ok().body("Question with ID : "+id+" deleted with success!");
    }

}
