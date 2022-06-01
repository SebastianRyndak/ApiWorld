package com.codecool.travelhelper.API.rapidapi.webclient.apiwebclient.weatherclient;

import com.codecool.travelhelper.API.rapidapi.model.apimodel.WeatherDto1;
import com.codecool.travelhelper.API.rapidapi.webclient.apiwebclient.ApiMetaData1;
import com.codecool.travelhelper.API.rapidapi.webclient.apiwebclient.ApiWebClient1;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WeatherClientImpl1 extends ApiWebClient1 implements WeatherClient1 {

    public WeatherClientImpl1() {
        super(ApiMetaData1.WEATHER);
    }

    public WeatherDto1 getCityWeather(String cityName) {
        Map<String, Object> parameters = new HashMap<>(){{
            put("q", cityName);
        }};
        this.setParameters(parameters);

        JsonObject response = getApiResponse(this.getUrl(), this.getHeadersData(), this.getParameters());
        System.out.println(response);

        WeatherDto1 weatherDto = getWeatherDto(response);
        System.out.println(weatherDto.toString());

        return weatherDto;
    }

    private WeatherDto1 getWeatherDto (JsonObject response){
        String mainParameter = getValueByKeyFromJsonObjectInsideJsonArray("main", "weather", response);
        String description = getValueByKeyFromJsonObjectInsideJsonArray("description", "weather", response);
        String icon = getValueByKeyFromJsonObjectInsideJsonArray("icon", "weather", response);

        float temperature = Float.parseFloat(getValueByKeyFromJsonObjectInsideJsonObject("temp", "main", response));
        float feelsLike = Float.parseFloat(getValueByKeyFromJsonObjectInsideJsonObject("feels_like", "main", response));
        int pressure = Integer.parseInt(getValueByKeyFromJsonObjectInsideJsonObject("pressure", "main", response));
        int humidity = Integer.parseInt(getValueByKeyFromJsonObjectInsideJsonObject("humidity", "main", response));

        float wingSpeed = Float.parseFloat(getValueByKeyFromJsonObjectInsideJsonObject("speed", "wind", response));

        WeatherDto1 weatherDto = WeatherDto1.builder()
                .mainParameter(mainParameter)
                .description(description)
                .icon(icon)
                .temperature(temperature)
                .feelsLike(feelsLike)
                .pressure(pressure)
                .humidity(humidity)
                .wingSpeed(wingSpeed)
                .build();

        return weatherDto;
    }
}
