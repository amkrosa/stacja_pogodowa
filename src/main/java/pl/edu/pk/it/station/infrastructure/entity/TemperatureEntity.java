package pl.edu.pk.it.station.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "temperature")
public class TemperatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
