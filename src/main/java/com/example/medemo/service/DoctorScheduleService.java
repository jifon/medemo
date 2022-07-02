package com.example.medemo.service;

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

    public List<DoctorSchedule> getAllDoctorSchedules() {
        return doctorScheduleRepository.findAll();
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
