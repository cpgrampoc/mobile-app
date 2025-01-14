package com.india.cpgram.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit retrofit = null;
  //  private static String BASE_URL = "http://13.203.120.124:3100/";
  //  private static String BASE_URL_LOGIN = "http://13.203.120.124:8087/";
    private static String BASE_URL = "http://103.15.83.51:3100/";
    private static String BASE_URL_LOGIN = "http://103.15.83.51:8087/";


    public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).readTimeout(200,TimeUnit.SECONDS).connectTimeout(200,TimeUnit.SECONDS).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
    public static Retrofit getClientLogin() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).readTimeout(200,TimeUnit.SECONDS).connectTimeout(200,TimeUnit.SECONDS).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_LOGIN)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

}