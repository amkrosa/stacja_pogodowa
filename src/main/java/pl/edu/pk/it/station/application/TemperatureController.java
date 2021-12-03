package pl.edu.pk.it.station.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pk.it.station.domain.temperature.Temperature;
import pl.edu.pk.it.station.domain.temperature.service.TemperatureService;
import pl.edu.pk.it.station.infrastructure.dto.TemperatureDto;

import java.util.List;

@RestController
@RequestMapping("/station")
public class TemperatureController {

    private final TemperatureService temperatureService;

    @Autowired
    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @RequestMapping(value = "/temperatures", method = RequestMethod.GET)
    public List<TemperatureDto> allTemperatures() {
        return temperatureService.getAll();
    }
}
