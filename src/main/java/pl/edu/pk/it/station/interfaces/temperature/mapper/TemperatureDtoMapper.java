package pl.edu.pk.it.station.interfaces.temperature.mapper;

import org.mapstruct.Mapper;
import pl.edu.pk.it.station.domain.temperature.Temperature;
import pl.edu.pk.it.station.interfaces.temperature.dto.TemperatureDto;

import java.util.List;

@Mapper
public interface TemperatureDtoMapper {
    List<TemperatureDto> toDtoList(List<Temperature> temperatures);
    TemperatureDto toDto(Temperature temperature);
}
