package ru.journalofracer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.journalofracer.model.WeatherEntity;
import ru.journalofracer.model.WeatherResponse;
import ru.journalofracer.service.WeatherService;
@Slf4j
@RestController
@RequestMapping("/weather")
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    @ResponseBody
    public ResponseEntity<WeatherResponse> getWeatherDataCity(@PathVariable String city) {
        log.info(city);
        WeatherResponse weatherCity = weatherService.getWeatherCity(city);

        return weatherCity != null
                ? ResponseEntity.ok(weatherCity)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/coord")
    @ResponseBody
    public ResponseEntity<WeatherEntity> getWeatherDataCoord(@RequestParam Double lat, @RequestParam Double lon) {
        log.info("lat {}; lon {}", lat, lon);
        WeatherEntity weatherEntity = weatherService.getWeatherCoord(lat,lon);

        return weatherEntity != null
                ? ResponseEntity.ok(weatherEntity)
                : ResponseEntity.notFound().build();
    }
}
