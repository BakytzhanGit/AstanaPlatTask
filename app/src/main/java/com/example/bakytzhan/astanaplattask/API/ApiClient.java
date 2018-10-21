package com.example.bakytzhan.astanaplattask.API;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class ApiClient {

    private static Retrofit places_retrofit;
    private static OkHttpClient okHttpClient;

    private static void initOkHttp(){
        if (okHttpClient == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(interceptor);

            okHttpClient = httpClient.build();
        }
    }

    public static Retrofit getPlaces_retrofit(){

        initOkHttp();

        if (places_retrofit == null) {
            places_retrofit = new Retrofit.Builder()
                    .baseUrl("https://gateway.mypost.kz")
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(
                            SimpleXmlConverterFactory.createNonStrict(
                                new Persister(new AnnotationStrategy())
                            )
                    )
                    .build();
        }
        return places_retrofit;
    }
}
