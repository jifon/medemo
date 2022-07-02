package com.example.medemo.service;

import com.example.medemo.dto.PatientDto;
import com.example.medemo.dto.PregnancyDto;
import com.example.medemo.mapper.PatientMapper;
import com.example.medemo.mapper.PregnancyMapper;
import com.example.medemo.model.Patient;
import com.example.medemo.model.Pregnancy;
import com.example.medemo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientDto> getAllPatients() {
        List<Patient> list = patientRepository.findAll();
        List<PatientDto> listDto = null;
        for(Patient patient : list ){
            listDto.add(PatientMapper.EntityToDto(patient));
        }
        return listDto;
    }

    public Optional<Patient> findById(long id) {
        return patientRepository.findById(id);
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public void delete(long id) {
        patientRepository.deleteById(id);
    }

}
