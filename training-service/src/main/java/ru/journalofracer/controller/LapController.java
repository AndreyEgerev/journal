package ru.journalofracer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.journalofracer.model.Laps;
import ru.journalofracer.service.LapService;

@RestController
@RequestMapping("/training/session")
public class LapController {

    @Autowired
    LapService lapService;

    @GetMapping("/{id}")
    public Laps getSessionById(@PathVariable Long id) {
        return lapService.findlap(id);
    }


}
