package com.codecool.travelhelper.API.rapidapi.service.apiservice;

import com.codecool.travelhelper.API.rapidapi.model.apimodel.WeatherDto1;
import com.codecool.travelhelper.API.rapidapi.webclient.apiwebclient.weatherclient.WeatherClientImpl1;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService1 {

    @Autowired
    private final WeatherClientImpl1 weatherClient;

    public WeatherDto1 getWeather(String cityName){
        WeatherDto1 response = weatherClient.getCityWeather(cityName);
        return response;
    }
}
