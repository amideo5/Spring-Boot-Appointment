package com.example.demo.repo;

import com.example.demo.models.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepo extends MongoRepository<Patient, Long> {

}
