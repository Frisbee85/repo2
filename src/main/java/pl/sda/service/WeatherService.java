package pl.sda.service;

import lombok.extern.slf4j.Slf4j;
import pl.sda.repository.WeatherRepository;
@Slf4j
public class WeatherService {

    private WeatherRepository repository;

    public WeatherService(final WeatherRepository repository) {
        this.repository = repository;
    }

    public String getWeatherForLondon(){
        String jsonWeather = repository.readRawJason();
        log.info("json weather: {}",jsonWeather);
        return jsonWeather;
    }
}
