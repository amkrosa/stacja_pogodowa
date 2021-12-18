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
    @NotNull(message = "Value field cannot be null")
    private double value;

    @JsonFormat(pattern = "HH:mm:ss")
    @NotNull(message = "Time field cannot be null")
    private LocalTime time;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Date field cannot be null")
    private LocalDate date;
}
