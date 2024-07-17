package ru.journalofracer.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.journalofracer.model.Session;
import ru.journalofracer.service.TrainingService;

@Slf4j
@RestController
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    TrainingService trainingService;

    @GetMapping("/{id}")
    public Session getSessionById(@PathVariable Long id){
        log.info("Pilot id {}", id);
        return trainingService.getSessionRaceId(id);
    }

    @PostMapping(consumes = "application/json")
//    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Session addPilot(@RequestBody Session session){
        log.info(session.toString());
        return trainingService.saveSession(session);
    }

    @PutMapping("/{id}")
    public Session updatePilot(@PathVariable Long id, @RequestBody Session session){
        return trainingService.saveSession(session);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePilot(@PathVariable Long id){
        trainingService.deleteSession(id);
    }
}
