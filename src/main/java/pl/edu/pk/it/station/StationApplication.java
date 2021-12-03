package pl.edu.pk.it.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class StationApplication {

    @Autowired
    public ConfigurableApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(StationApplication.class, args);
    }

}
