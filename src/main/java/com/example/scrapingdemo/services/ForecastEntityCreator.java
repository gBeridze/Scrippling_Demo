package com.example.scrapingdemo.services;

import com.example.scrapingdemo.models.Forecast;

import java.util.Set;

public interface ForecastEntityCreator {
    public void createEntitySet() throws Exception;
    public Set<Forecast> getForecastsSet();
}
