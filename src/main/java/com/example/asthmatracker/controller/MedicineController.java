package com.example.asthmatracker.controller;

import com.example.asthmatracker.models.Medicine;
import com.example.asthmatracker.models.TakingMedication;
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

    /**
     * Создать запись с лекарством
     * */
    @PostMapping("/create-medicine")
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineService.createMedicine(medicine);
    }

    /**
     * Получить лекарство по имени
     * */
    @GetMapping("/by-name")
    public List<Medicine> getAllMedicine(
            @RequestParam(required = false) String name) {
        return medicineService.getMedicineByName(name);
    }

    /**
     * Получить лекарство назначенное пациенту
     * */
    @GetMapping("/by-patient")
    public List<Medicine> getMedicineByPatient(
            @RequestParam Integer patient_id) {
        return medicineService.getMedicineByPatient(patient_id);
    }

    /**
     * Зарегистрировать прием лекарства пациентом
     * */
    @PostMapping("taking-medication")
    public TakingMedication postTakingMedication(@RequestBody TakingMedication takingMedication) {
        return medicineService.postTakingMedication(takingMedication);
    }
}
