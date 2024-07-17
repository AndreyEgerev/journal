package ru.journalofracer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "weather")
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private double lon;
    @Column
    private double lat;
    @Column
    private String nameCity;
    @Column
    private int idCity;
    @Column
    private String country;
    @Column
    private LocalDateTime dt;
    //Weather
    @Column
    private int idWeather;
    @Column
    private String main;
    @Column
    private String description;
    @Column
    private String icon;
    //Main
    @Column
    private double temp;
    @Column
    private double feelsLike;
    @Column
    private double pressure;
    @Column
    private int humidity;
    @Column
    private double tempMin;
    @Column
    private double tempMax;
    //Wind
    @Column
    private double speed;
    @Column
    private int deg;
    //Clouds
    @Column
    private int allClouds;
}
