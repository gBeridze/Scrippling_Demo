package com.example.scrapingdemo.controllers;

import com.example.scrapingdemo.repositories.WeatherRepository;
import com.example.scrapingdemo.services.ForecastEntityCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.DayOfWeek;
import java.util.List;

@RestController
@RequestMapping(path = "/")
public class DataLoaderController {

    WeatherRepository weatherRepository;
    ForecastEntityCreator forecastEntityCreator;

    public DataLoaderController(WeatherRepository weatherRepository, ForecastEntityCreator forecastEntityCreator) {
        this.weatherRepository = weatherRepository;
        this.forecastEntityCreator = forecastEntityCreator;
    }

    @GetMapping(path = "/w")
    public List getTemperatureBy(@RequestParam String city, @RequestParam String day) {

        DayOfWeek d = DayOfWeek.valueOf(day);
        return weatherRepository.findByDayAndCity(city , d);
    }

    @PostConstruct
    public void Load(){

        try{
            forecastEntityCreator.createEntitySet();
            weatherRepository.saveAll(forecastEntityCreator.getForecastsSet());

        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
