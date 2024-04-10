package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholder {
    @GET("coins/markets?vs_currency=usd&order=market_cap_descS")
    Call<List<App>> getApp();

}
