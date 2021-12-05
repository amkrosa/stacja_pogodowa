package pl.edu.pk.it.station.domain.temperature.repository;

import pl.edu.pk.it.station.domain.temperature.Temperature;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface TemperatureRepository {
    List<Temperature> getLast(int n);
    List<Temperature> getAll();
    void save(Temperature temperature);
    void saveAll(List<Temperature> temperatures);
}
