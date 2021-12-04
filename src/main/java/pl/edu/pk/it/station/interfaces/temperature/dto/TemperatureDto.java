package pl.edu.pk.it.station.interfaces.temperature.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TemperatureDto implements Serializable {
    private double value;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime time;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
