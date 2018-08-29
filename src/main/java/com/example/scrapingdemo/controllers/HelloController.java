package com.example.scrapingdemo.controllers;

import com.example.scrapingdemo.models.Forecast;
import com.example.scrapingdemo.repositories.WeatherRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.*;
import java.nio.charset.Charset;

@Controller
public class HelloController {

    WeatherRepository weatherRepository;

    public HelloController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }



    @RequestMapping("/t")
    public void Test(){

        }


}
