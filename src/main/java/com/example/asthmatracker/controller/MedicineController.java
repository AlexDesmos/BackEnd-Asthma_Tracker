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

    @GetMapping
    public List<Medicine> getAllMedicine(
            @RequestParam(required = false) String name) {
        return medicineService.getMedicineByName(name);
    }
}
