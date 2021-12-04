package pl.edu.pk.it.station.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import pl.edu.pk.it.station.domain.temperature.Temperature;
import pl.edu.pk.it.station.infrastructure.entity.TemperatureEntity;

@Mapper
public interface TemperatureEntityMapper {
    TemperatureEntity toEntity(Temperature temperature, @MappingTarget TemperatureEntity entity);
    Temperature toTemperature(TemperatureEntity temperature);
}
