package pl.edu.pk.it.station.domain.temperature.service;

import pl.edu.pk.it.station.domain.temperature.Temperature;

import java.time.LocalDate;
import java.util.List;

public interface TemperatureService {
    List<Temperature> getLast(int n);
    List<Temperature> getAll();
    List<Temperature> getFiltered(LocalDate date,
                                  LocalDate fromDate,
                                  Double fromValue,
                                  Double toValue);
    void saveAll(List<Temperature> temperatures);
}
