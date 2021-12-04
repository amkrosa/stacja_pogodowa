package pl.edu.pk.it.station.domain.temperature;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Temperature {
    private Integer id_temperature;
    private double value;
    private LocalDate date;
    private LocalTime time;
}
