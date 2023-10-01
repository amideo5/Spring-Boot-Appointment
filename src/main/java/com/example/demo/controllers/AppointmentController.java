package com.example.demo.controllers;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.models.Appointment;
import com.example.demo.models.Doctor;
import com.example.demo.models.Patient;
import com.example.demo.repo.AppointmentRepo;
import com.example.demo.repo.DoctorRepo;
import com.example.demo.repo.PatientRepo;
import com.example.demo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public String createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        try {
            Appointment createdAppointment = appointmentService.createAppointment(appointmentDTO);
            ResponseEntity.status(HttpStatus.CREATED).body(createdAppointment);
            return createdAppointment.toString();
        } catch (IllegalArgumentException e) {
            return e.toString();
        }
    }
}

