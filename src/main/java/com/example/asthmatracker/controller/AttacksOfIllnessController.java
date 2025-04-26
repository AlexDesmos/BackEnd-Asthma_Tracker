package com.example.asthmatracker.controller;

import com.example.asthmatracker.models.AttacksOfIllness;
import com.example.asthmatracker.service.AttacksOfIllnessService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
