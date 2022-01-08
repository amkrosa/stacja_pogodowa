package pl.edu.pk.it.station.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pk.it.station.domain.temperature.Temperature;
import pl.edu.pk.it.station.infrastructure.entity.TemperatureEntity;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface TemperatureCrudRepository extends JpaRepository<TemperatureEntity, Integer> {

    @Query(value = "select * FROM temperature ORDER BY id_temperature desc LIMIT ?1", nativeQuery = true)
    List<TemperatureEntity> getLast(int n);

    List<TemperatureEntity> findByDateEquals(LocalDate date);
    
    List<TemperatureEntity> findByValueBetween(double from, double to);

    List<TemperatureEntity> findByDateAfterOrderByDateAscTimeAsc(LocalDate date);
}
