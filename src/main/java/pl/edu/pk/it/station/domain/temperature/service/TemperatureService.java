package pl.edu.pk.it.station.domain.temperature.service;

import pl.edu.pk.it.station.domain.temperature.Temperature;
import pl.edu.pk.it.station.infrastructure.dto.TemperatureDto;

import java.util.List;

public interface TemperatureService {
    List<TemperatureDto> getAll();
}
