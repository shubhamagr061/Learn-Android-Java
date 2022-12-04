package com.akshara.becomputer.api;

import com.akshara.becomputer.response.FoodResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("api/food")
    Call<FoodResponse> getFood();

}
