package com.jamshidbek.shoppingapp.Base;

import com.google.gson.JsonObject;
import com.jamshidbek.shoppingapp.Model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MainApi {

    @POST("/v1/auth-token/")
    Call<User> login(@Body User user);

    @POST("/v1/user/")
    Call<User> createUser(@Body User user);

    @GET("/v1/classificiation/")
    Call<ArrayList<JsonObject>> getClassifications();
}
