package com.example.asthmatracker.controller;

import com.example.asthmatracker.models.Medicine;
import com.example.asthmatracker.service.MedicineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicine")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineService.createMedicine(medicine);
    }

    @GetMapping("/by-name")
    public List<Medicine> getAllMedicine(
            @RequestParam(required = false) String name) {
        return medicineService.getMedicineByName(name);
    }

    @GetMapping("/by-patient")
    public List<Medicine> getMedicineByPatient(
            @RequestParam Integer patient_id) {
        return medicineService.getMedicineByPatient(patient_id);
    }
}
