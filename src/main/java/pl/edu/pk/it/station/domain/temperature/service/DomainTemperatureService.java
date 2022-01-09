package pl.edu.pk.it.station.domain.temperature.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.edu.pk.it.station.domain.temperature.repository.TemperatureRepository;
import pl.edu.pk.it.station.domain.temperature.Temperature;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

@Log4j2
@Service
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
    public List<Temperature> getFiltered(LocalDate date,
                                         LocalDate fromDate,
                                         Double fromValue,
                                         Double toValue) {
        List<Temperature> list = new ArrayList<>();
        if (date!=null) {
            list.addAll(temperatureRepository.getSingleDate(date));
        } else if (fromValue != null && toValue != null) {
            list.addAll(temperatureRepository.getBetweenValues(fromValue, toValue));
        } else if (fromDate != null) {
            list.addAll(temperatureRepository.getFromDate(fromDate));
        }
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    @Override
    public void saveAll(List<Temperature> temperatures) {
        temperatureRepository.saveAll(temperatures);
    }
}
