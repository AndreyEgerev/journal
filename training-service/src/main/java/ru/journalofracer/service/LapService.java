package ru.journalofracer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.journalofracer.exception.TrainingNotFoundException;
import ru.journalofracer.model.Laps;
import ru.journalofracer.repository.LapsRepository;

@Service
public class LapService {
    @Autowired
    LapsRepository lapsRepository;

    public Laps findlap(Long id) {
        return lapsRepository.findById(id)
                .orElseThrow(() -> new TrainingNotFoundException("Session Laps " + id + " not found"));
    }

    public Laps saveLaps(Laps laps) {
        return lapsRepository.save(laps);
    }

    public void deleteLaps(Long id) {
        lapsRepository.deleteById(id);
    }
}
