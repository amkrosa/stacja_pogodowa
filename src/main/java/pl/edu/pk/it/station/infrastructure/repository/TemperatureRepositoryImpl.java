package pl.edu.pk.it.station.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.edu.pk.it.station.domain.temperature.repository.TemperatureRepository;
import pl.edu.pk.it.station.domain.temperature.Temperature;
import pl.edu.pk.it.station.infrastructure.entity.TemperatureEntity;
import pl.edu.pk.it.station.infrastructure.mapper.TemperatureEntityMapper;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
@RequiredArgsConstructor
public class TemperatureRepositoryImpl implements TemperatureRepository {

    private final TemperatureCrudRepository temperatureCrudRepository;
    private final TemperatureEntityMapper temperatureEntityMapper;

    @Override
    public List<Temperature> getLast(int n) {
        var query = temperatureCrudRepository.getLast(n);
        return temperatureEntityMapper.toTemperatureList(query);
    }

    @Override
    public List<Temperature> getAll() {
        var all = new ArrayList<>(temperatureCrudRepository.findAll());
        return temperatureEntityMapper.toTemperatureList(all);
    }

    @Override
    public List<Temperature> getBetweenValues(double from, double to) {
        var query = temperatureCrudRepository.findByValueBetween(from, to);
        return temperatureEntityMapper.toTemperatureList(query);
    }

    @Override
    public List<Temperature> getSingleDate(LocalDate date) {
        var query = temperatureCrudRepository.findByDateEquals(date);
        return temperatureEntityMapper.toTemperatureList(query);
    }

    @Override
    public List<Temperature> getFromDate(LocalDate fromDate) {
        var query = temperatureCrudRepository.findByDateAfter(fromDate);
        return temperatureEntityMapper.toTemperatureList(query);
    }

    @Override
    public void save(Temperature temperature) {
        var entity = temperatureEntityMapper.toEntity(temperature, new TemperatureEntity());
        temperatureCrudRepository.save(entity);
    }

    @Override
    public void saveAll(List<Temperature> temperatures) {
        var entities = temperatures.stream()
                .map(temp -> temperatureEntityMapper.toEntity(temp, new TemperatureEntity()))
                .collect(Collectors.toList());
        temperatureCrudRepository.saveAll(entities);
    }
}
