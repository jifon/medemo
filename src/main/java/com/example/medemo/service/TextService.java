package com.example.medemo.service;

import com.example.medemo.model.Text;
import com.example.medemo.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TextService {

    @Autowired
    private TextRepository textRepository;

    public List<Text> getAllProducts() {
        return textRepository.findAll();
    }

    public Optional<Text> findById(long id) {
        return textRepository.findById(id);
    }

    public Text save(Text text) {
        return textRepository.save(text);
    }

    public void delete(long id) {
        textRepository.deleteById(id);
    }

}
