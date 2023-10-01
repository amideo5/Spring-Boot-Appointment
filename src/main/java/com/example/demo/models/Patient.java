package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

@Document(collection = "patient")
@TypeAlias("patient")
@Getter
@Setter
public class Patient {

    private static final AtomicLong idGenerator = new AtomicLong(Instant.now().getEpochSecond());

    @Id
    private Long id = idGenerator.getAndIncrement();
    private String name;
    private String email;

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
