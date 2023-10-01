package com.example.demo.service;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.models.Doctor;
import com.example.demo.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;

    public Doctor createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDTO.getName());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setSchedule(doctorDTO.getSchedule());
        doctor.setMaxPatients(doctorDTO.getMaxPatients());
        doctor.setCurr(doctorDTO.getCurr());
        return doctorRepo.save(doctor);
    }
}
