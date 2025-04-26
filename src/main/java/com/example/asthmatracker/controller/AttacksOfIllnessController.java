package com.example.asthmatracker.controller;

import com.example.asthmatracker.models.AttacksOfIllness;
import com.example.asthmatracker.service.AttacksOfIllnessService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attacks")
public class AttacksOfIllnessController {

    private final AttacksOfIllnessService attacksOfIllnessService;

    public AttacksOfIllnessController(AttacksOfIllnessService attacksOfIllnessService) {
        this.attacksOfIllnessService = attacksOfIllnessService;
    }

    @PostMapping
    public AttacksOfIllness postAttack(@RequestBody AttacksOfIllness attacksOfIllness) {
        return attacksOfIllnessService.postAttack(attacksOfIllness);
    }

    @GetMapping
    public List<AttacksOfIllness> getAttacksByDates(
            @RequestParam(required = false) LocalDate start_date,
            @RequestParam(required = false) LocalDate end_date
    ) {
        return attacksOfIllnessService.getAttacksByFilter(start_date, end_date);
    }
}
