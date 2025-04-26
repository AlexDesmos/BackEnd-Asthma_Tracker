package com.example.asthmatracker.controller;

import com.example.asthmatracker.models.Spirometry;
import com.example.asthmatracker.service.SpirometryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/spirometry")
public class SpirometryController {

    private final SpirometryService spirometryService;

    public SpirometryController(SpirometryService spirometryService) {
        this.spirometryService = spirometryService;
    }

    @PostMapping
    public Spirometry postSpirometry(@RequestBody Spirometry spirometry) {
        return spirometryService.postResultOfSpirometry(spirometry);
    }
}
