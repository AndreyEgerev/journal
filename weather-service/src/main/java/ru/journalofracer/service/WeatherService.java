package ru.journalofracer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.journalofracer.exception.CityNotFoundException;

import ru.journalofracer.model.WeatherEntity;
import ru.journalofracer.model.WeatherResponse;
import ru.journalofracer.repository.WeatherRepository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Slf4j
@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.urlcoor}")
    private String apiUrlCoord;

    private WebClient webClient;

    @Autowired
    WeatherRepository weatherRepository;

    /**
     * {"coord":{"lon":37.7708,"lat":44.7239},
     * "weather":[{"id":802,"main":"Clouds","description":"переменная облачность","icon":"03n"}],
     * "base":"stations",
     * "main":{"temp":28.25,"feels_like":29.83,"temp_min":28.25,"temp_max":28.25,"pressure":1009,"humidity":60,"sea_level":1009,"grnd_level":989},
     * "visibility":10000,
     * "wind":{"speed":1.58,"deg":107,"gust":1.87},
     * "clouds":{"all":41},
     * "dt":1721171142,
     * "sys":{"type":1,"id":8962,"country":"RU","sunrise":1721181561,"sunset":1721236224},
     * "timezone":10800,"id":518255,"name":"Новороссийск","cod":200}
     * @param city
     * @return
     */
    public WeatherResponse getWeatherCity(String city){
        String url = apiUrl + "?q=" + city + "&appid=" + apiKey + "&units=metric&lang=ru";
        log.info(url);
        webClient = WebClient.builder()
                .baseUrl(url)
                .build();

        WeatherResponse weather = webClient.get()
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .onErrorResume(error -> Mono.error(new CityNotFoundException("error 404 City " + city +" not found")))
                .blockOptional()
                .orElse(null);
        log.info(weather.toString());
        WeatherEntity weatherEntity = convertWeatherResponseToEntity(weather);
        weatherEntity = weatherRepository.save(weatherEntity);
        log.info(weatherEntity.toString());
        return weather;
    }


    public WeatherEntity getWeatherCoord(Double lat, Double lon) {
        String url = apiUrlCoord + "?lat=" + lat + "&lon=" + lon +
                "&appid=" + apiKey+ "&units=metric&lang=ru";
        log.info(url);
        webClient = WebClient.builder()
                .baseUrl(url)
                .build();

        WeatherResponse weather = webClient.get()
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .onErrorResume(error ->
                        Mono.error(new CityNotFoundException("error 404 Coordinate " + lat +"; " + lon + " not found")))
                .blockOptional()
                .orElse(null);
        log.info(weather.toString());
        WeatherEntity weatherEntity= convertWeatherResponseToEntity(weather);
        log.info(weatherEntity.toString());

        return weatherRepository.save(weatherEntity);
    }

    public WeatherEntity convertWeatherResponseToEntity(WeatherResponse weatherResponse) {
        WeatherEntity weatherEntity = new WeatherEntity();

        // Coord
        weatherEntity.setLon(weatherResponse.getLon());
        weatherEntity.setLat(weatherResponse.getLat());

        // City
        weatherEntity.setNameCity(weatherResponse.getName());
        weatherEntity.setIdCity(weatherResponse.getId());
        weatherEntity.setCountry(weatherResponse.getCountry());

        // Weather
        weatherEntity.setIdWeather(weatherResponse.getIdWeather());
        weatherEntity.setMain(weatherResponse.getMain());
        weatherEntity.setDescription(weatherResponse.getDescription());
        weatherEntity.setIcon(weatherResponse.getIcon());

        // Main
        weatherEntity.setTemp(weatherResponse.getTemp());
        weatherEntity.setFeelsLike(weatherResponse.getFeelsLike());
        weatherEntity.setPressure(weatherResponse.getPressure());
        weatherEntity.setHumidity(weatherResponse.getHumidity());
        weatherEntity.setTempMin(weatherResponse.getTempMin());
        weatherEntity.setTempMax(weatherResponse.getTempMax());

        // Wind
        weatherEntity.setSpeed(weatherResponse.getSpeed());
        weatherEntity.setDeg(weatherResponse.getDeg());

        // Clouds
        weatherEntity.setAllClouds(weatherResponse.getAll());

        // dt
        weatherEntity.setDt(LocalDateTime.ofEpochSecond(weatherResponse.getDt(), 0, ZoneOffset.UTC));

        return weatherEntity;
    }
}
