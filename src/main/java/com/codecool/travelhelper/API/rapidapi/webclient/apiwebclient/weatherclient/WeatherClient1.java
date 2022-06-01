package com.codecool.travelhelper.API.rapidapi.webclient.apiwebclient.weatherclient;


import com.codecool.travelhelper.API.rapidapi.model.apimodel.WeatherDto1;

public interface WeatherClient1 {

    WeatherDto1 getCityWeather(String cityName);
}
