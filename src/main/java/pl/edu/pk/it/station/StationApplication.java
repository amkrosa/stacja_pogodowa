package pl.edu.pk.it.station;

import org.springdoc.core.SpringDocUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalTime;

@SpringBootApplication
public class StationApplication {

    public static void main(String[] args) {
        SpringDocUtils.getConfig().replaceWithClass(LocalTime.class, String.class);
        SpringApplication.run(StationApplication.class, args);
    }

}
