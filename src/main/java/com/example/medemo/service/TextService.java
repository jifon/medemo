package com.example.medemo.service;

import com.example.medemo.dto.TextDto;
import com.example.medemo.exception.NotFoundException;
import com.example.medemo.mapper.TextMapper;
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

    public List<TextDto> getAllProducts() {
        List<Text> list = textRepository.findAll();
        List<TextDto> listDto = null;
        for(Text text : list ){
            listDto.add(TextMapper.EntityToDto(text));
        }
        return listDto;
    }

    public Optional<TextDto> findById(long id) {
        Text text = textRepository.findById(id).orElseThrow(()->new NotFoundException("No text with ID : "+id));
        return Optional.of(TextMapper.EntityToDto(text));
    }

    public TextDto save(TextDto text) {
        return TextMapper.EntityToDto(textRepository.save(TextMapper.DtoToEntity(text)));
    }

    public TextDto update(long id, TextDto dto){
        Text text = textRepository.findById(id).orElseThrow(()->new NotFoundException("No text with ID : "+id));
        Text newText = TextMapper.DtoToEntity(dto);
        newText.setId(text.getId());
        return TextMapper.EntityToDto(textRepository.save(newText));
    }

    public void delete(long id) {
        Text text = textRepository.findById(id)
                .orElseThrow(()->new NotFoundException("No text with ID : "+id));
        textRepository.delete(text);
    }

}
