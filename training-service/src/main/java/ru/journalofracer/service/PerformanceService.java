package ru.journalofracer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.journalofracer.exception.TrainingNotFoundException;
import ru.journalofracer.model.PerformanceSimple;
import ru.journalofracer.repository.PerformanceRepository;

@Service
public class PerformanceService {
    @Autowired
    PerformanceRepository performanceRepository;

    public PerformanceSimple getPerformance(Long id){
        return performanceRepository.findById(id)
                .orElseThrow(() -> new TrainingNotFoundException("Training Performance " + id + " not found"));
    }

    public void deletePerformance(Long id){
        performanceRepository.deleteById(id);
    }

    public PerformanceSimple savePerformance(PerformanceSimple performance) {
        return performanceRepository.findById(performance.getId())
                        .map(exist -> {
                            exist.setComment(performance.getComment());
                            exist.setPilotWeight(performance.getPilotWeight());
                            exist.setCargoWeight(performance.getCargoWeight());
                            exist.setDrivenGearRatio(performance.getDrivenGearRatio());
                            exist.setLeadingGearRatio(performance.getLeadingGearRatio());
                            exist.setGearRatio(performance.getLeadingGearRatio()/performance.getDrivenGearRatio());
                            return performanceRepository.save(exist);
                        })
                        .orElseGet(() -> performanceRepository.save(performance));
    }

    //todo получение веса пилота и вставка его
}
