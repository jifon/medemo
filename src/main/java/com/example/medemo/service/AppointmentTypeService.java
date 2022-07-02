package com.example.medemo.service;

import com.example.medemo.model.AppointmentType;
import com.example.medemo.model.Text;
import com.example.medemo.repository.AppointmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentTypeService {

    @Autowired
    private AppointmentTypeRepository repository;

    public List<AppointmentType> getAllAppointmentTypes() {
        return repository.findAll();
    }

    public Optional<AppointmentType> findById(long id) {
        return repository.findById(id);
    }

    public AppointmentType save(AppointmentType appointmentType) {
        return repository.save(appointmentType);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
