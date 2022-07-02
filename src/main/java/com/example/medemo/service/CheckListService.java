package com.example.medemo.service;

import com.example.medemo.dto.CheckListDto;
import com.example.medemo.mapper.CheckListMapper;
import com.example.medemo.model.CheckList;
import com.example.medemo.repository.CheckListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckListService {

    @Autowired
    private CheckListRepository repository;


    public List<CheckListDto> getAllCheckLists() {
        List<CheckList> list = repository.findAll();
        List<CheckListDto> listDto = null;
        for(CheckList checkList : list ){
            listDto.add(CheckListMapper.EntityToDto(checkList));
        }
        return listDto;
    }


    public Optional<CheckListDto> findById(long id) {

        Optional<CheckList> text = repository.findById(id);
        return Optional.of(CheckListMapper.EntityToDto(text.get()));
    }



    public CheckListDto save(CheckListDto text) {
        return CheckListMapper.EntityToDto(repository.save(CheckListMapper.DtoToEntity(text)));
    }

    public void delete(long id) {
        repository.deleteById(id);
    }




}
