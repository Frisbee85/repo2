package pl.sda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.repository.WeatherRepository;
import pl.sda.service.WeatherService;

@RestController
public class WeatherRestController {

    private WeatherService service;

    private WeatherRestController(WeatherService service){
        this.service= service;
    }

    @GetMapping("/london")
    public String weather1() {
        return service.getWeatherForLondon();

    }
@GetMapping("/weather/city/{city}")
    public String weatherForCity(@PathVariable String city){
        return service.getWeatherForCity(city);
    }
}
