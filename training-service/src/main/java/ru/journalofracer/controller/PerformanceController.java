package ru.journalofracer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.journalofracer.model.PerformanceSimple;
import ru.journalofracer.service.PerformanceService;

@RestController
@RequestMapping("/training/performance")
public class PerformanceController {

    @Autowired
    PerformanceService performanceService;

    @GetMapping("/{}id")
    public PerformanceSimple getPerformanceById(@PathVariable Long id) {
        return performanceService.getPerformance(id);
    }

    @PutMapping("/{id}")
    public PerformanceSimple updatePerformance(@PathVariable Long id, @RequestBody PerformanceSimple performance) {
        return performanceService.savePerformance(performance);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerformance(@PathVariable Long id) {
        performanceService.deletePerformance(id);
    }
}
