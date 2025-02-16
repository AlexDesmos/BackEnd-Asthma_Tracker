package com.example.asthmatracker.controller;

import com.example.asthmatracker.models.Patient;
import com.example.asthmatracker.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @GetMapping
    public List<Patient> getPatientsByFilter(
            @RequestParam(required = false) String full_name,
            @RequestParam(required = false) String oms) {
        return patientService.getPatientsByFilter(full_name, oms);
    }
}
