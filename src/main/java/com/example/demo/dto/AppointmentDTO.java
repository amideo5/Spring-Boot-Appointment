package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@Component
public class AppointmentDTO {

    private Long doctorId;
    private Long patientId;
    private String appointmentTime;
}
