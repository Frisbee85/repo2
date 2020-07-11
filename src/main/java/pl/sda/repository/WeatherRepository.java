package pl.sda.repository;

import org.springframework.web.client.RestTemplate;

public class WeatherRepository {
    private RestTemplate restTemplate;

    private static final String LONDON_CONNECTION_URL=
            "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02";

    private static final String CONNECTION_URL=
            "https://samples.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

    public WeatherRepository(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String readRawJason(){
       return restTemplate.getForObject(LONDON_CONNECTION_URL,String.class);
    }

    public String  readWeatherForCity(String city){
        return "";
    }
}
