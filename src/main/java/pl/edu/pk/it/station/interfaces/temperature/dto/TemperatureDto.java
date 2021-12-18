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
    @NotBlank(message = "Value field cannot be empty")
    @NotNull(message = "Value field cannot be null")
    private double value;

    @JsonFormat(pattern = "HH:mm:ss")
    @NotBlank(message = "Time field cannot be empty")
    @NotNull(message = "Time field cannot be null")
    private LocalTime time;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotBlank(message = "Date field cannot be empty")
    @NotNull(message = "Date field cannot be null")
    private LocalDate date;
}
