package com.example.medemo.service;

import com.example.medemo.model.CheckList;
import com.example.medemo.model.Question;
import com.example.medemo.model.Text;
import com.example.medemo.repository.CheckListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckListService {

    @Autowired
    private CheckListRepository repository;

    public List<CheckList> getAllCheckLists() {
        return repository.findAll();
    }

    public Optional<CheckList> findById(long id) {
        return repository.findById(id);
    }

    public CheckList save(CheckList checkList) {
        return repository.save(checkList);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }


}
