package com.example.medemo.service;

import com.example.medemo.model.Answer;
import com.example.medemo.model.Text;
import com.example.medemo.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository repository;

    public List<Answer> getAllAnswers() {
        return repository.findAll();
    }

    public Optional<Answer> findById(long id) {
        return repository.findById(id);
    }

    public Answer save(Answer answer) {
        return repository.save(answer);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

}
