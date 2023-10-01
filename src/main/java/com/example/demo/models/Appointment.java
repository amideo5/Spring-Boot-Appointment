package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

@Document(collection = "appointment")
@TypeAlias("appointment")
@Getter
@Setter
public class Appointment {

    private static final AtomicLong idGenerator = new AtomicLong(Instant.now().getEpochSecond());

    @Id
    private Long id = idGenerator.getAndIncrement();
    private Doctor doctor;
    private String appointmentTime;
    private Patient patient;

    @Override
    public String toString() {
        return "Appointment{" +
                "doctor=" + doctor +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", patient=" + patient +
                '}';
    }
}

