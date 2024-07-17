package ru.journalofracer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pilot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private LocalDate birthday;
    @Column
    private Long number;

    // Размеры
    @Column
    private LocalDate date;
    @Column
    private Long height;
    @Column
    private Double weight;
    @Column
    private Long footSize;
}
