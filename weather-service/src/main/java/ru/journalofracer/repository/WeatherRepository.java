package ru.journalofracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.journalofracer.model.WeatherEntity;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
}
