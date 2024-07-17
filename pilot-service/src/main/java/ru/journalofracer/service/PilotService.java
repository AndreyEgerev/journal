package ru.journalofracer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.journalofracer.exception.PilotNotFoundException;
import ru.journalofracer.repository.PilotRepository;
import ru.journalofracer.model.Pilot;

import java.time.LocalDate;

@Slf4j
@Service
//@RequiredArgsConstructor
public class PilotService {
    @Autowired
    PilotRepository pilotRepository;

    public Pilot getPilotById(Long id){
        return pilotRepository.findById(id)
                .orElseThrow(() -> new PilotNotFoundException("Pilot " + id + " not found"));
    }

    public Pilot savePilot(Pilot pilot){
        //return pilotRepository.findByNameAndBirthdate(pilot.getName(), pilot.getBirthday())
        return pilotRepository.findById(pilot.getId())
                .map(existingPilot -> {
                    existingPilot.setName(pilot.getName());
                    existingPilot.setSurname(pilot.getSurname());
                    existingPilot.setNumber(pilot.getNumber());
                    existingPilot.setHeight(pilot.getHeight());
                    existingPilot.setWeight(pilot.getWeight());
                    existingPilot.setFootSize(pilot.getFootSize());
                    existingPilot.setDate(LocalDate.now());

                    return pilotRepository.save(existingPilot);
                })
                .orElseGet(() -> pilotRepository.save(pilot));
    }

    public void deletePilot(Long id){
        pilotRepository.deleteById(id);
    }

}
