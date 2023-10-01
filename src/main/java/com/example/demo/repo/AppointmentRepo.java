package com.example.demo.repo;

import com.example.demo.models.Appointment;
import com.example.demo.models.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepo extends MongoRepository<Appointment, Long> {

    Optional<Appointment> findById(Long id);
}
