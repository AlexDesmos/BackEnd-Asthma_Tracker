package com.example.asthmatracker.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Patient {
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthday;
    private String email;
    private String phone_number;
    private String oms;
    private Integer id;
}
