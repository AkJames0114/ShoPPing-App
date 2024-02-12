package com.jamshidbek.shoppingapp.Base;

import com.jamshidbek.shoppingapp.Model.Banner;
import com.jamshidbek.shoppingapp.Model.Category;
import com.jamshidbek.shoppingapp.Model.Classification;
import com.jamshidbek.shoppingapp.Model.Product;
import com.jamshidbek.shoppingapp.Model.Subproduct;
import com.jamshidbek.shoppingapp.Model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

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
    Call<ArrayList<Classification>> getClassifications();

    @GET("/v1/classification/{id}/category/")
    Call<ArrayList<Category>> getCategoryWithClassification(@Path("id") int classificationId);

    @GET("/v1/category/{id}/subproduct/")
    Call<ArrayList<Subproduct>> getSubproductWithCategory(@Path("id") int categoryId);


    // Home Page

    @GET("/v1/banner/")
    Call<ArrayList<Banner>> getBanners();

    @GET("/v1/popular/")
    Call<ArrayList<Product>> getPopularProducts();

    // Products

    @GET("/v1/subproduct/{id}/products/")
    Call<ArrayList<Product>> getProducts(@Path("id") int subproductId);

    @GET("/v1/product/{id}/")
    Call<Product> getProductDetails(@Path("id") int productId);
}
