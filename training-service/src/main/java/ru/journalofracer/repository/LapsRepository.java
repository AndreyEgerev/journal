package ru.journalofracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.journalofracer.model.Laps;

@Repository
public interface LapsRepository extends JpaRepository<Laps, Long> {
}