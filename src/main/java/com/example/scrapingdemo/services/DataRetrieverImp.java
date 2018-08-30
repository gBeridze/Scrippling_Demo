package com.example.scrapingdemo.services;

import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DataRetrieverImp implements DataRetriever{

    @Value("${json.url}")
    String url;

    OkHttpClient httpClient = new OkHttpClient();

    @Override
    public String getJsonAsString() throws Exception
    {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }



}
