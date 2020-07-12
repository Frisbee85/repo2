package pl.sda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.domain.Country;
import pl.sda.domain.StatisticData;
import pl.sda.domain.WeatherForecast;

@RestController
public class CountryController {

    @GetMapping("/my-country")
    public Country myCountry(){
        return new Country("Warsaw","Polka",new StatisticData(40_000_000));
    }
}
