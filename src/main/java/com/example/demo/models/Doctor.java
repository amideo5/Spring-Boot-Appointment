package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

@Document(collection = "doctor")
@TypeAlias("doctor")
@Getter
@Setter
public class Doctor {

    private static final AtomicLong idGenerator = new AtomicLong(Instant.now().getEpochSecond());

    @Id
    private Long id = idGenerator.getAndIncrement();
    private String name;
    private String specialization;
    private int maxPatients;
    private String schedule;
    private int curr;

    public Doctor() {
    }

    public Doctor(String name, String specialization, int maxPatients, String schedule) {
        this.name = name;
        this.specialization = specialization;
        this.maxPatients = maxPatients;
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", maxPatients=" + maxPatients +
                ", schedule='" + schedule + '\'' +
                ", curr=" + curr +
                '}';
    }
}
