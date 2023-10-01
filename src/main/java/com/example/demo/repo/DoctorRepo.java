package com.example.demo.repo;

import com.example.demo.models.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepo extends MongoRepository<Doctor, Long> {

    Optional<Doctor> findByName(String name);
}
