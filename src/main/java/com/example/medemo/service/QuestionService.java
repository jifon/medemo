package com.example.medemo.service;

import com.example.medemo.dto.QuestionDto;
import com.example.medemo.mapper.QuestionMapper;
import com.example.medemo.model.Question;
import com.example.medemo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<QuestionDto> getAllQuestion() {
        List<Question> list = questionRepository.findAll();
        List<QuestionDto> listDto = null;
        for(Question question : list ){
            listDto.add(QuestionMapper.EntityToDto(question));
        }
        return listDto;
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
