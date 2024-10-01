package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.EarthquakeData;
import java.util.Optional;

public interface EarthquakeDataRepository extends JpaRepository<EarthquakeData, Long> {
    Optional<EarthquakeData> findByEventID(String eventID);
}
