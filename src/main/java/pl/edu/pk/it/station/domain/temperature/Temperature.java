package pl.edu.pk.it.station.domain.temperature;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Temperature {
    private BigInteger id_temperature;
    private double value;
    private LocalDate date;
    private LocalTime time;

    public Temperature(final BigInteger id_temperature, final double value) {
        this.id_temperature = id_temperature;
        this.value = value;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }
}
