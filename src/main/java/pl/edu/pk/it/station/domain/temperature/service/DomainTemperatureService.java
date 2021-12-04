package pl.edu.pk.it.station.domain.temperature.service;

import pl.edu.pk.it.station.domain.temperature.repository.TemperatureRepository;
import pl.edu.pk.it.station.domain.temperature.Temperature;

import java.util.List;

public class DomainTemperatureService implements TemperatureService {

    private final TemperatureRepository temperatureRepository;

    public DomainTemperatureService(final TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    @Override
    public List<Temperature> getAll() {
        return temperatureRepository.getAll();
    }

    @Override
    public void saveAll(List<Temperature> temperatures) {
        temperatureRepository.saveAll(temperatures);
    }
}
