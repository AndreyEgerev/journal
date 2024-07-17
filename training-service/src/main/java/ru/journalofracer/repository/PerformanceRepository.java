package ru.journalofracer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.journalofracer.model.PerformanceSimple;

@Repository
public interface PerformanceRepository extends JpaRepository<PerformanceSimple, Long> {
}
