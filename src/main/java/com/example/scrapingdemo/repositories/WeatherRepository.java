package com.example.scrapingdemo.repositories;

import com.example.scrapingdemo.models.Forecast;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;
@Repository
public interface WeatherRepository extends CrudRepository<Forecast , Long> {

    @Query("select f from Forecast f where f.day = :day AND f.city = :city")
    List<Forecast> findByDayAndCity(@Param("city") String city , @Param("day") DayOfWeek day);
}
