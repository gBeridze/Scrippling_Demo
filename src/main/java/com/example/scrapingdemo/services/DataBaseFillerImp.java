package com.example.scrapingdemo.services;

import com.example.scrapingdemo.models.Forecast;
import com.example.scrapingdemo.repositories.WeatherRepository;
import com.google.gson.JsonArray;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;


@Service
public class DataBaseFillerImp implements DataBaseFiller {

    DataRetriever dataRetriever;
    String city;
    DayOfWeek dayOfWeek;
    double temperature;

    @Value("${json.url}")
    String url;

    WeatherRepository weatherRepository;

    public DataBaseFillerImp(DataRetriever dataRetriever, WeatherRepository weatherRepository) {
        this.dataRetriever = dataRetriever;
        this.weatherRepository = weatherRepository;
    }

    public void AddToDatabase()
    throws  Exception
    {

        String json = dataRetriever.getJsonAsString(url);
        //city


        for(int i = 0; i < 7;i++){
            Forecast forecast = new Forecast();
            String var = JsonPath.read(json ,"$.timezone");
            String[] vars = var.split("/");

            city = vars[1];
            forecast.setCity(city);
            System.out.println(var);


            //summary

            var = JsonPath.read(json , "$.daily.data.["+i+"].summary");
            System.out.println(var);
            forecast.setWeatherState(var);

            //day


            forecast.setDay(DayOfWeek.of(i+1));

            //temp

            Double d = JsonPath.read(json , "$.daily.data.[" +i+"].temperatureMin");
            System.out.println(d);
            forecast.setTemperature(d);
            weatherRepository.save(forecast);
        }








    }





}
