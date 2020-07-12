package pl.sda.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Repository
public class WeatherRepository {
    private final RestTemplate restTemplate;
    private final String applicationKey;


    private static final String LONDON_CONNECTION_URL =
            "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02";

    private static final String CONNECTION_URL =
            "https://samples.openweathermap.org/data/2.5/weather?q={city}&appid={key}";

    private static final String DEFAULT_KEY = "439d4b804bc8187953eb36d2a8c26a02";

    public WeatherRepository(final RestTemplate restTemplate,
                            // @Value("${WEATHER_KEY:no-key}") String applicationKey) {
                             @Value("${weather.key:no-key}") String applicationKey) {

        this.restTemplate = restTemplate;
        this.applicationKey= applicationKey;
        log.info("weather.key: [{}]",applicationKey);
    }

    public String readRawJason() {
        return restTemplate.getForObject(LONDON_CONNECTION_URL, String.class);
    }

    public String readWeatherForCity(String city) {
        Map<String, String> requestParams = Map.of(
                "city", city,
                "key", DEFAULT_KEY);

        ResponseEntity<String> response = restTemplate.getForEntity(CONNECTION_URL, String.class, requestParams);
        log.info("response: [{}]", response);
        log.info("response status: [{}]", response.getStatusCode());
        response
                .getHeaders()
                .forEach((key, value) -> log.info("header key: [{}] - value: [{}]",
                        key, value));
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return "{}";
    }
}
