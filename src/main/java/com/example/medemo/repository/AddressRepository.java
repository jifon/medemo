package com.example.medemo.repository;

import com.example.medemo.model.Address;
import com.example.medemo.model.Anamnesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
