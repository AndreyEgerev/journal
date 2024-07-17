package ru.journalofracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.journalofracer.model.Session;

public interface TrainingRepository extends JpaRepository<Session, Long> {
}
