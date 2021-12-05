package pl.edu.pk.it.station.interfaces.temperature.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pk.it.station.domain.temperature.service.TemperatureService;
import pl.edu.pk.it.station.interfaces.temperature.dto.TemperatureListDto;
import pl.edu.pk.it.station.interfaces.temperature.mapper.TemperatureDtoMapper;

@RequiredArgsConstructor
@RestController
@RequestMapping("/station")
public class TemperatureController {

    private final TemperatureService temperatureService;
    private final TemperatureDtoMapper temperatureDtoMapper;

    @RequestMapping(value = "/temperatures", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('SCOPE_api')")
    public TemperatureListDto allTemperatures() {
        var temperatures = temperatureService.getAll();
        var dto = new TemperatureListDto();
        dto.setItemList(temperatureDtoMapper.toDtoList(temperatures));
        return dto;
    }

    @RequestMapping(value = "/temperatures", consumes = "application/json", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('SCOPE_api')")
    public TemperatureListDto insertTemperatures(@RequestBody TemperatureListDto temperatureListDto) {
        var request = temperatureDtoMapper.toTemperatureList(temperatureListDto.getItemList());
        temperatureService.saveAll(request);
        return temperatureListDto;
    }
}
