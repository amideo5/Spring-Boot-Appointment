package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class DoctorDTO {
    private String name;
    private String specialization;
    private int maxPatients;
    private String schedule;
    private int curr;
}
