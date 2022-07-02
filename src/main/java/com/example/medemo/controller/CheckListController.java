package com.example.medemo.controller;

import com.example.medemo.dto.CheckListDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.model.CheckList;
import com.example.medemo.service.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CheckListController {


    @Autowired
    private CheckListService checkListService;

    @GetMapping(value="/checkList")
    List<CheckListDto> getAll(){
        return checkListService.getAllCheckLists();
    }

    @GetMapping(value="/checkList/{id}")
    ResponseEntity<CheckListDto> getById(@PathVariable("id") long id) {
        CheckListDto dto = checkListService.findById(id)
                .orElseThrow(()->new NotFoundException("No checkList with ID : "+id));
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping(value="/checkList")
    ResponseEntity<CheckListDto> createCheckList(@RequestBody CheckListDto dto) {

        CheckListDto newEntity = checkListService.save(dto);
        return ResponseEntity.ok().body(newEntity);
    }

    @PutMapping(value="/checkList/{id}")
    ResponseEntity<CheckListDto> updateCheckList(@PathVariable("id") long id, @RequestBody CheckListDto dto) {

        CheckListDto checkListDto = checkListService.findById(id)
                .orElseThrow(()->new NotFoundException("No checkList with ID : "+id));
        return ResponseEntity.ok().body(checkListService.save(checkListDto));
    }

//    @DeleteMapping(value="/checkList/{id}")
//    ResponseEntity deleteCheckList( @PathVariable("id") long id) {
//        CheckList checkList = checkListService.findById(id)
//                .orElseThrow(()->new NotFoundException("No checkList with ID : "+id));
//        checkListService.delete(checkList.getId());
//        return ResponseEntity.ok().body("СheckList with ID : "+id+" deleted with success!");
//    }

}
