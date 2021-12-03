package pl.edu.pk.it.station.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pk.it.station.infrastructure.dto.TemperatureDto;

import java.math.BigInteger;

@Repository
public interface TemperatureCrudRepository extends CrudRepository<TemperatureDto, BigInteger> {
}
