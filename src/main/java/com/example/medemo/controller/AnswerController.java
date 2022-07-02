package com.example.medemo.controller;

import com.example.medemo.dto.AnswerDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.AnswerMapper;
import com.example.medemo.model.Answer;
import com.example.medemo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping(value="/answer")
    List<Answer> getAll(){
        return answerService.getAllAnswers();
    }

    @GetMapping(value="/answer/{id}")
    ResponseEntity<Answer> getById(@PathVariable("id") long id) {
        Answer answer = answerService.findById(id)
                .orElseThrow(()->new NotFoundException("No Answer with ID : "+id));
        return ResponseEntity.ok().body(answer);
    }

    @PostMapping(value="/answer")
    ResponseEntity<?> createAnswer(@RequestBody AnswerDto dto) {
        Answer answer = AnswerMapper.DtoToEntity(dto);
        Answer addedAnswer = answerService.save(answer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedAnswer.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/answer/{id}")
    ResponseEntity<Answer> updateAnswer(@PathVariable("id") long id, @RequestBody AnswerDto dto) {
        Answer answer = answerService.findById(id)
                .orElseThrow(()->new NotFoundException("No Answer with ID : "+id));

        Answer newAnswer = AnswerMapper.DtoToEntity(dto);
        newAnswer.setId(answer.getId());
        answerService.save(newAnswer);
        return ResponseEntity.ok().body(newAnswer);
    }

    @DeleteMapping(value="/answer/{id}")
    ResponseEntity deleteAnswer( @PathVariable("id") long id) {
        Answer answer = answerService.findById(id)
                .orElseThrow(()->new NotFoundException("No Answer with ID : "+id));
        answerService.delete(answer.getId());
        return ResponseEntity.ok().body("Answer with ID : "+id+" deleted with success!");
    }
}
