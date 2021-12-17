package pl.edu.pk.it.station.infrastructure.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.SpringDocUtils;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;

@Configuration
public class SwaggerConfig {
    public SwaggerConfig() {
        SpringDocUtils.getConfig().replaceWithClass(LocalTime.class, String.class);
    }
}
