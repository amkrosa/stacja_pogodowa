package pl.edu.pk.it.station.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "temperature")
public class TemperatureDto {
    @Id
    @GeneratedValue
    private Integer id_temperature;
    @Column(name = "value")
    private double value;
    @Column(name = "date", updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(name = "time", updatable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime time;
}
