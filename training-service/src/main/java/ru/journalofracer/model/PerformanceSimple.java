package ru.journalofracer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "performance")
public class PerformanceSimple {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "performance")
    private Session session;

    // Перед
    @Column
    private int frontWidth;
    @Column
    private double frontLeftTirePressureBefore;
    @Column
    private double frontLeftTirePressureAfter;
    @Column
    private double frontRightTirePressureBefore;
    @Column
    private double frontRightTirePressureAfter;

    // Зад
    @Column
    private int rearWidth;
    @Column
    private int rearHeight;
    @Column
    private double rearLeftTirePressureBefore;
    @Column
    private double rearLeftTirePressureAfter;
    @Column
    private double rearRightTirePressureBefore;
    @Column
    private double rearRightTirePressureAfter;

    // Передаточное соотношение
    @Column
    private double gearRatio;
    @Column
    private double leadingGearRatio;
    @Column
    private double drivenGearRatio;

    // Двигатель
    @Column
    private String model;
    @Column
    private String number;

    // Кол-во кругов
    @Column
    private int lapCount;

    // Лучший круг
    @Column
    private String bestLapTime;
    // Вес
    @Column
    private double totalWeight;
    @Column
    private double pilotWeight;
    @Column
    private double cargoWeight;

    @Column
    private String comment;
}
