package com.jamshidbek.shoppingapp.Base;

import android.content.Context;

import com.jamshidbek.shoppingapp.BuildConfig;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static String baseUrl = "http://dev-api.shoppingmall.beknumonov.com";

    private static Retrofit mRetrofit;


    public static Retrofit provideRetrofit(Context context) {

        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(provideOkHttpClient(context))
                    .build();
        }
        return mRetrofit;
    }

    private static OkHttpClient provideOkHttpClient(Context context) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        boolean isDevelopment = BuildConfig.DEBUG;
        //If Development true show log(body), if not (none). This will avoid users to have access to the data and safe from hacking.
        logging.setLevel(isDevelopment ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        return new OkHttpClient().newBuilder()
                .addInterceptor(logging)
                .addInterceptor(provideAccessTokenInterceptor(context))
                .build();

    }

    private static Interceptor provideAccessTokenInterceptor(Context context) {
        return chain -> {
            Request original = chain.request();

            HttpUrl originalUrl = original.url();

            HttpUrl.Builder urlBuilder = originalUrl.newBuilder();

            HttpUrl url = urlBuilder.build();

            Request.Builder requestBuilder = original.newBuilder().url(url);

            if (context != null) {
                String access_token = (String) PreferenceManager.getInstance(context).getValue(String.class, "access_token", "");

                if (!access_token.isEmpty()){
                    requestBuilder.addHeader("Authorization", "Bearer " + access_token);

                }
            }
            Request request = requestBuilder.build();
            return chain.proceed(request);

        };
    }

    public static <T> T provideApi(Class<T> services, Context context) {
        return provideRetrofit(context).create(services);
    }
}
