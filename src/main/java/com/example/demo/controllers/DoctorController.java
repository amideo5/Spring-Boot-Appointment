package com.example.demo.controllers;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.models.Doctor;
import com.example.demo.repo.DoctorRepo;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable String name) {
        Optional<Doctor> doctor = doctorRepo.findByName(name);
        return doctor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody DoctorDTO doctorDTO) {
        Doctor createdDoctor = doctorService.createDoctor(doctorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDoctor);
    }
}
