package com.example.medemo.service;

import com.example.medemo.dto.DoctorDto;
import com.example.medemo.dto.DoctorScheduleDto;
import com.example.medemo.mapper.DoctorMapper;
import com.example.medemo.mapper.DoctorScheduleMapper;
import com.example.medemo.model.Doctor;
import com.example.medemo.model.DoctorSchedule;
import com.example.medemo.model.Text;
import com.example.medemo.repository.DoctorScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorScheduleService {

    @Autowired
    private DoctorScheduleRepository doctorScheduleRepository;

    public List<DoctorScheduleDto> getAllDoctorSchedules() {
        List<DoctorSchedule> list = doctorScheduleRepository.findAll();
        List<DoctorScheduleDto> listDto = null;
        for(DoctorSchedule entity : list ){
            listDto.add(DoctorScheduleMapper.EntityToDto(entity));
        }
        return listDto;
    }

    public Optional<DoctorSchedule> findById(long id) {
        return doctorScheduleRepository.findById(id);
    }

    public DoctorSchedule save(DoctorSchedule doctorSchedule) {
        return doctorScheduleRepository.save(doctorSchedule);
    }

    public void delete(long id) {
        doctorScheduleRepository.deleteById(id);
    }

}
