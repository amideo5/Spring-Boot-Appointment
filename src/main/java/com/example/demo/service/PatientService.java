package com.example.demo.service;

import com.example.demo.dto.PatientDTO;
import com.example.demo.models.Patient;
import com.example.demo.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;

    public Patient createPatient(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setEmail(patientDTO.getEmail());

        return patientRepo.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepo.findById(id);
    }
}

