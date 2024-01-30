package com.jamshidbek.shoppingapp.Base;

import com.google.gson.JsonObject;
import com.jamshidbek.shoppingapp.Model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MainApi {

    @POST("/v1/login/")
    Call<User> login(@Body User user);

    @POST("/v1/user/")
    Call<User> createUser(@Body User user);

    /*Lesson 35. 1:54:00

    @GET("/v1/user/verify_email/")
    Call<JsonObject> requestVerifyEmail(@Query("email")String email);

    @POST("/v1/user/verify_email/")
    Call<JsonObject> verifyEmailWithCode(@Body VerifyEmail verifyEmail);
    */

    @GET("/v1/classificiation/")
    Call<ArrayList<JsonObject>> getClassifications();
}
