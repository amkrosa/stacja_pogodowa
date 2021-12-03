package pl.edu.pk.it.station.domain.temperature.service;

import pl.edu.pk.it.station.domain.temperature.Temperature;
import pl.edu.pk.it.station.domain.temperature.repository.TemperatureRepository;
import pl.edu.pk.it.station.infrastructure.dto.TemperatureDto;

import java.util.List;

public class DomainTemperatureService implements TemperatureService {

    private final TemperatureRepository temperatureRepository;

    public DomainTemperatureService(final TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    @Override
    public List<TemperatureDto> getAll() {
        return temperatureRepository.getAll();
    }
}
