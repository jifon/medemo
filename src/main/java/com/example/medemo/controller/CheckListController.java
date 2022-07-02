package com.example.medemo.controller;

import com.example.medemo.dto.CheckListDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.CheckListMapper;
import com.example.medemo.model.CheckList;
import com.example.medemo.service.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CheckListController {


    @Autowired
    private CheckListService checkListService;

    @GetMapping(value="/checkList")
    List<CheckList> getAll(){
        return checkListService.getAllCheckLists();
    }

    @GetMapping(value="/checkList/{id}")
    ResponseEntity<CheckList> getById(@PathVariable("id") long id) {
        CheckList checkList = checkListService.findById(id)
                .orElseThrow(()->new NotFoundException("No checkList with ID : "+id));
        return ResponseEntity.ok().body(checkList);
    }

    @PostMapping(value="/checkList")
    ResponseEntity<?> createCheckList(@RequestBody CheckListDto dto) {
        CheckList checkList = CheckListMapper.DtoToEntity(dto);
        CheckList addedCheckList = checkListService.save(checkList);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedCheckList.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/checkList/{id}")
    ResponseEntity<CheckList> updateCheckList(@PathVariable("id") long id, @RequestBody CheckListDto dto) {
        CheckList checkList = checkListService.findById(id)
                .orElseThrow(()->new NotFoundException("No checkList with ID : "+id));

        CheckList newCheckList = CheckListMapper.DtoToEntity(dto);
        newCheckList.setId(checkList.getId());
        checkListService.save(newCheckList);
        return ResponseEntity.ok().body(newCheckList);
    }

    @DeleteMapping(value="/checkList/{id}")
    ResponseEntity deleteCheckList( @PathVariable("id") long id) {
        CheckList checkList = checkListService.findById(id)
                .orElseThrow(()->new NotFoundException("No checkList with ID : "+id));
        checkListService.delete(checkList.getId());
        return ResponseEntity.ok().body("СheckList with ID : "+id+" deleted with success!");
    }

}
