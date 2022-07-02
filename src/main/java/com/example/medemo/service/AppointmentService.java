package com.example.medemo.service;

import com.example.medemo.model.Appointment;
import com.example.medemo.model.Text;
import com.example.medemo.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }

    public Optional<Appointment> findById(long id) {
        return repository.findById(id);
    }

    public Appointment save(Appointment appointment) {
        return repository.save(appointment);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
