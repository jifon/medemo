package com.example.medemo.service;

import com.example.medemo.dto.DoctorDto;
import com.example.medemo.dto.LaboratoryResearchDto;
import com.example.medemo.mapper.DoctorMapper;
import com.example.medemo.mapper.LaboratoryResearchMapper;
import com.example.medemo.model.Doctor;
import com.example.medemo.model.LaboratoryResearch;
import com.example.medemo.model.Text;
import com.example.medemo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorDto> getAllDoctors() {
        List<Doctor> list = doctorRepository.findAll();
        List<DoctorDto> listDto = null;
        for(Doctor entity : list ){
            listDto.add(DoctorMapper.EntityToDto(entity));
        }
        return listDto;
    }

    public Optional<Doctor> findById(long id) {
        return doctorRepository.findById(id);
    }

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void delete(long id) {
        doctorRepository.deleteById(id);
    }

}
