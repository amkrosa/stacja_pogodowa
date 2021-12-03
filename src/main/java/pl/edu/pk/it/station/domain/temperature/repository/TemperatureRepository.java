package pl.edu.pk.it.station.domain.temperature.repository;

import pl.edu.pk.it.station.domain.temperature.Temperature;
import pl.edu.pk.it.station.infrastructure.dto.TemperatureDto;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface TemperatureRepository {
    Optional<TemperatureDto> findById(BigInteger id);
    List<TemperatureDto> getAll();
}
