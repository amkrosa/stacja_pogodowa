package pl.edu.pk.it.station.domain.temperature.service;

import lombok.RequiredArgsConstructor;
import pl.edu.pk.it.station.domain.temperature.repository.TemperatureRepository;
import pl.edu.pk.it.station.domain.temperature.Temperature;

import java.util.List;

@RequiredArgsConstructor
public class DomainTemperatureService implements TemperatureService {

    private final TemperatureRepository temperatureRepository;

    @Override
    public List<Temperature> getLast(int n) {
        return temperatureRepository.getLast(n);
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
