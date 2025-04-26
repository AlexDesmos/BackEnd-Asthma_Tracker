package com.example.asthmatracker.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Spirometry {
    private Integer id;
    private Integer patient_id;
    private BigDecimal result;
    private LocalDateTime date_time;
}
