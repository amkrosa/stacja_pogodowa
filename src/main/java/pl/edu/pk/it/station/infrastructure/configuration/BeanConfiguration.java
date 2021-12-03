package pl.edu.pk.it.station.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.edu.pk.it.station.StationApplication;
import pl.edu.pk.it.station.domain.temperature.repository.TemperatureRepository;
import pl.edu.pk.it.station.domain.temperature.service.DomainTemperatureService;
import pl.edu.pk.it.station.domain.temperature.service.TemperatureService;

@Configuration
@ComponentScan(basePackageClasses = StationApplication.class)
public class BeanConfiguration {

    @Bean
    TemperatureService temperatureService(final TemperatureRepository temperatureRepository) {
        return new DomainTemperatureService(temperatureRepository);
    }
}
