package pl.edu.pk.it.station.interfaces.temperature.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TemperatureDto implements Serializable {
    @NotNull
    @NotBlank
    private double value;

    @JsonFormat(pattern = "HH:mm:ss")
    @NotNull
    @NotBlank
    private LocalTime time;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @NotBlank
    private LocalDate date;
}
