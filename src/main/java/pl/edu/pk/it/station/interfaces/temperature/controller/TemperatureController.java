package pl.edu.pk.it.station.interfaces.temperature.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pk.it.station.domain.temperature.service.TemperatureService;
import pl.edu.pk.it.station.interfaces.temperature.dto.TemperatureListDto;
import pl.edu.pk.it.station.interfaces.temperature.mapper.TemperatureDtoMapper;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Validated
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

    @RequestMapping(value = "/temperatures/filter", method = RequestMethod.GET)
    public TemperatureListDto allTemperatures(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                              @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
                                              @RequestParam(required = false) Double fromValue,
                                              @RequestParam(required = false) Double toValue) {
        var temperatures = temperatureService.getFiltered(date, fromDate,
                fromValue, toValue);
        var dto = new TemperatureListDto();
        dto.setItemList(temperatureDtoMapper.toDtoList(temperatures));
        return dto;
    }

    @RequestMapping(value = "/temperatures", consumes = "application/json", method = RequestMethod.POST)
    public TemperatureListDto insertTemperatures(@RequestBody @Valid TemperatureListDto temperatureListDto) {
        var request = temperatureDtoMapper.toTemperatureList(temperatureListDto.getItemList());
        temperatureService.saveAll(request);
        var responseList = temperatureDtoMapper.toDtoList(temperatureService.getLast(temperatureListDto.getItemList().size()));
        var response = new TemperatureListDto();
        response.setItemList(responseList);
        return response;
    }
}
