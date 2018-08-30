package com.example.scrapingdemo.services;

import com.example.scrapingdemo.models.Forecast;
import com.example.scrapingdemo.repositories.WeatherRepository;
import com.jayway.jsonpath.JsonPath;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;


@Service
public class ForecastEntityCreatorImp implements ForecastEntityCreator {

    private DataRetriever dataRetriever;
    private WeatherRepository weatherRepository;
    private Set<Forecast> forecastsSet = new HashSet<>();

    public ForecastEntityCreatorImp(DataRetriever dataRetriever, WeatherRepository weatherRepository) {
        this.dataRetriever = dataRetriever;
        this.weatherRepository = weatherRepository;
    }

    public Set<Forecast> getForecastsSet() {
        return forecastsSet;
    }

    public void setForecastsSet(Set<Forecast> forecastsSet) {
        this.forecastsSet = forecastsSet;
    }

    public void createEntitySet()
    throws  Exception
    {

        String json = dataRetriever.getJsonAsString();
        //city


        for(int i = 0; i < 7;i++){
            Forecast forecast = new Forecast();
            String var = JsonPath.read(json ,"$.timezone");
            String[] vars = var.split("/");


            forecast.setCity(vars[1]);
            System.out.println(vars[1]);


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

            forecastsSet.add(forecast);

        }








    }





}
