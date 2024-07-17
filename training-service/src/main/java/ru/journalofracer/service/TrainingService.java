package ru.journalofracer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.journalofracer.exception.TrainingNotFoundException;
import ru.journalofracer.model.Laps;
import ru.journalofracer.model.PerformanceSimple;
import ru.journalofracer.model.Session;
import ru.journalofracer.repository.TrainingRepository;

@Slf4j
@Service
public class TrainingService {

    @Autowired
    TrainingRepository trainingRepository;
    @Autowired
    LapService lapService;
    @Autowired
    PerformanceService performanceService;

    public Session getSessionRaceId(Long id) {
        return trainingRepository.findById(id)
                .orElseThrow(() -> new TrainingNotFoundException("Training " + id + " not found"));
    }

    public void deleteSession(Long id){
        trainingRepository.deleteById(id);
    }

    public Session saveSession(Session session) {
        return trainingRepository.findById(session.getId())
                .map(existingSession -> {
                    existingSession.setPerformance(session.getPerformance());
                    existingSession.setNumberPilot(session.getNumberPilot());
                    existingSession.setCity(session.getCity());
                    return trainingRepository.save(existingSession);
                })
                .orElseGet(() -> {
                    Laps lap = lapService.saveLaps(session.getLaps());
                    PerformanceSimple performance = performanceService.savePerformance(session.getPerformance());
                    session.setLaps(lap);
                    session.setPerformance(performance);
                    return trainingRepository.save(session);
                });
    }

//    private Weather getCurrentWeather() {
//        return null;
//    }

}
