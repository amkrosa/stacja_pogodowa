package pl.edu.pk.it.station.interfaces.temperature.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class TemperatureListDto {
    @Valid
    @NotEmpty
    private List<TemperatureDto> itemList;
}
