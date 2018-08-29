package com.example.scrapingdemo;

import com.example.scrapingdemo.services.DataBaseFiller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.DayOfWeek;

@SpringBootApplication

public class ScrapingDemoApplication {

    public static void main(String[] args) throws Exception {

         ApplicationContext ctx = SpringApplication.run(ScrapingDemoApplication.class, args);
        //



    }

}
