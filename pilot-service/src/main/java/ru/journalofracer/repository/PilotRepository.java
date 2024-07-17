package ru.journalofracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.journalofracer.model.Pilot;

public interface PilotRepository extends JpaRepository<Pilot, Long> {
}
