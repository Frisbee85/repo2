package pl.sda.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.domain.WeatherForecast;
import pl.sda.service.WeatherService;

import java.util.Map;

@Slf4j
@RestController
public class WeatherRestController {

    private WeatherService service;


    private WeatherRestController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/london")
    public String weather1() {
        log.info("Weather for London");
        return service.getWeatherForLondon();

    }

    @GetMapping("/weather/city/{city}")
    public String weatherForCity(@PathVariable String city) {
        return service.getWeatherForCity(city);
    }

    @GetMapping("/weather-forecast/{city}")
    public WeatherForecast weatherForecast(@PathVariable String city) {
        return service.getWeatherForecastForCity(city);
    }

    @PostMapping("/london")
    @ResponseStatus(HttpStatus.CREATED)
    public WeatherForecast saveWeatherForecast(@RequestBody WeatherForecast objectToSave) {
        log.debug("object to save: [{}]", objectToSave);
        return objectToSave;
    }

    @PostMapping("/london1")
    public ResponseEntity<WeatherForecast> saveWeatherForecast1(@RequestBody WeatherForecast objectToSave) {
        log.debug("object to save: [{}]", objectToSave);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, "/weather-forecast/1");

        ResponseEntity<WeatherForecast> responseEntity = new ResponseEntity<WeatherForecast>
                (objectToSave, headers, HttpStatus.CREATED);

        return responseEntity;
    }
}
