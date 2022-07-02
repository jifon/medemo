package com.example.medemo.repository;

import com.example.medemo.model.User;
import com.example.medemo.model.constants.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByStatus(Status active);

    boolean existsByEmail(String email);
}
