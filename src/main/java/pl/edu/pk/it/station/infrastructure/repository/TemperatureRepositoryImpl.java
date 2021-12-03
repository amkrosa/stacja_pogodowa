package pl.edu.pk.it.station.infrastructure.repository;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.edu.pk.it.station.domain.temperature.Temperature;
import pl.edu.pk.it.station.domain.temperature.repository.TemperatureRepository;
import pl.edu.pk.it.station.infrastructure.dto.TemperatureDto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Primary
@Log4j2
public class TemperatureRepositoryImpl implements TemperatureRepository {

    private final TemperatureCrudRepository temperatureCrudRepository;

    @Autowired
    public TemperatureRepositoryImpl(final TemperatureCrudRepository temperatureCrudRepository) {
        this.temperatureCrudRepository = temperatureCrudRepository;
    }

    @Override
    public Optional<TemperatureDto> findById(BigInteger id) {
        return temperatureCrudRepository.findById(id);
    }

    @Override
    public List<TemperatureDto> getAll() {
        var all = temperatureCrudRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false).collect(Collectors.toList());
    }
}
