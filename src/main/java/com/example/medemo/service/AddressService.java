package com.example.medemo.service;

import com.example.medemo.model.Address;
import com.example.medemo.model.Text;
import com.example.medemo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public List<Address> getAllAddresses() {
        return repository.findAll();
    }

    public Optional<Address> findById(long id) {
        return repository.findById(id);
    }

    public Address save(Address address) {
        return repository.save(address);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
