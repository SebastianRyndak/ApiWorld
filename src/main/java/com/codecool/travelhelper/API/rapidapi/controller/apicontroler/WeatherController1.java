package com.codecool.travelhelper.API.rapidapi.controller.apicontroler;

import com.codecool.travelhelper.API.rapidapi.model.apimodel.WeatherDto1;
import com.codecool.travelhelper.API.rapidapi.service.apiservice.WeatherService1;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class WeatherController1 {

    @Autowired
    private final WeatherService1 weatherService;

    @GetMapping("/")
    public String test() {
        return "test";
    }

    @GetMapping("/weather/{cityName}")
    public WeatherDto1 getWeather(@PathVariable String cityName){
        return weatherService.getWeather(cityName);
    }
}