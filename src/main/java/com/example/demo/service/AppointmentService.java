package com.example.demo.service;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.enums.Schedule;
import com.example.demo.models.Appointment;
import com.example.demo.models.Doctor;
import com.example.demo.models.Patient;
import com.example.demo.repo.AppointmentRepo;
import com.example.demo.repo.DoctorRepo;
import com.example.demo.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepository;

    @Autowired
    private AppointmentDTO appointmentDTO;

    @Autowired
    private DoctorRepo doctorRepository;

    @Autowired
    private PatientRepo patientRepository;

    public Appointment createAppointment(AppointmentDTO appointmentDTO) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(appointmentDTO.getDoctorId());
        Optional<Patient> optionalPatient = patientRepository.findById(appointmentDTO.getPatientId());

        if (optionalDoctor.isPresent() && optionalPatient.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            Patient patient = optionalPatient.get();

            Appointment appointment = new Appointment();
            appointment.setDoctor(doctor);
            appointment.setPatient(patient);
            String app = appointmentDTO.getAppointmentTime();
            if (Schedule.contains(app)) {
                appointment.setAppointmentTime(app);
            } else {
                throw new IllegalArgumentException("Doctor not available");
            }
            int current = doctor.getCurr();
            if(current<10){
                current=current+1;
                doctor.setCurr(current);
                doctorRepository.save(doctor);
            }
            else{
                throw new IllegalArgumentException("Doctor full");
            }
            return appointmentRepository.save(appointment);
        } else {
            throw new IllegalArgumentException("Invalid doctorId or patientId");
        }
    }
}

