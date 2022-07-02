package com.example.medemo.service;

import com.example.medemo.model.Question;
import com.example.medemo.model.Text;
import com.example.medemo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    public Optional<Question> findById(long id) {
        return questionRepository.findById(id);
    }

    public Question save(Question text) {
        return questionRepository.save(text);
    }

    public void delete(long id) {
        questionRepository.deleteById(id);
    }
}
