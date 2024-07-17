package ru.journalofracer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "laps")
public class Laps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDateTime sessionDateTime;
    @Column
    private List<LocalDateTime> lapTimes;
    @OneToOne(mappedBy = "laps")
    private Session session;

//todo расчет времени лучшего круга и среднего времени прохождения круги

}
