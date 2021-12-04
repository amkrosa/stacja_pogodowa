package pl.edu.pk.it.station.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pk.it.station.domain.temperature.Temperature;
import pl.edu.pk.it.station.infrastructure.entity.TemperatureEntity;

import java.math.BigInteger;

@Repository
public interface TemperatureCrudRepository extends CrudRepository<TemperatureEntity, Integer> {
}
