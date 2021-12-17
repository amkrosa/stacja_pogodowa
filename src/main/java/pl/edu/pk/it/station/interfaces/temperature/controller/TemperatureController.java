package pl.edu.pk.it.station.interfaces.temperature.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
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
    public TemperatureListDto allTemperatures() {
        var temperatures = temperatureService.getAll();
        var dto = new TemperatureListDto();
        dto.setItemList(temperatureDtoMapper.toDtoList(temperatures));
        return dto;
    }

    @RequestMapping(value = "/temperatures", consumes = "application/json", method = RequestMethod.POST)
    public TemperatureListDto insertTemperatures(@RequestBody TemperatureListDto temperatureListDto) {
        try {
            var request = temperatureDtoMapper.toTemperatureList(temperatureListDto.getItemList());
            temperatureService.saveAll(request);
            var responseList = temperatureDtoMapper.toDtoList(temperatureService.getLast(temperatureListDto.getItemList().size()));
            var response = new TemperatureListDto();
            response.setItemList(responseList);
            return response;
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }
}
