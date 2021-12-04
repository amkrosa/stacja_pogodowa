package pl.edu.pk.it.station.interfaces.temperature.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
public class TemperatureListDto {
    private List<TemperatureDto> itemList;
}
