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
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDateTime dateTraining;
    @Column
    private String city;
    @Column
    private Long idPilot;
    @Column
    private Long numberPilot;
    @Column
    private Long idWeather;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "laps_id")
    private Laps laps;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "performance_id")
    private PerformanceSimple performance;
}
