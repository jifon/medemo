package com.example.medemo.service;

import com.example.medemo.model.Content;
import com.example.medemo.model.Text;
import com.example.medemo.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    @Autowired
    private ContentRepository repository;

    public List<Content> getAllContents() {
        return repository.findAll();
    }

    public Optional<Content> findById(long id) {
        return repository.findById(id);
    }

    public Content save(Content content) {
        return repository.save(content);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

}
