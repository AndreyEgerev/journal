package ru.journalofracer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.journalofracer.model.Pilot;
import ru.journalofracer.service.PilotService;

@Slf4j
@RestController
@RequestMapping("/pilot")
//@RequiredArgsConstructor
public class PilotController {
    @Autowired
    PilotService pilotService;

    @GetMapping("/{id}")
    public Pilot getPilotById(@PathVariable Long id){
        log.info("Pilot id {}", id);
        return pilotService.getPilotById(id);
    }

    @PostMapping(consumes = "application/json")
//    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Pilot addPilot(@RequestBody Pilot pilot){
        log.info(pilot.toString());
        return pilotService.savePilot(pilot);
    }

    @PutMapping("/{id}")
    public Pilot updatePilot(@PathVariable Long id, @RequestBody Pilot pilot){
        return pilotService.savePilot(pilot);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePilot(@PathVariable Long id){
        pilotService.deletePilot(id);
    }
}
