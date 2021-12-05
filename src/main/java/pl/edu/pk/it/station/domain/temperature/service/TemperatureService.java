package pl.edu.pk.it.station.domain.temperature.service;

import pl.edu.pk.it.station.domain.temperature.Temperature;

import java.util.List;

public interface TemperatureService {
    List<Temperature> getLast(int n);
    List<Temperature> getAll();
    void saveAll(List<Temperature> temperatures);
}
