package com.example.bakytzhan.astanaplattask.API;


import com.example.bakytzhan.astanaplattask.PlacesResp;

import io.reactivex.Single;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @Headers({"Content-Type: application/x-www-form-urlencoded; charset=utf-8"})
    @POST(".")
    Single<PlacesResp> getPlaces(@Body RequestBody body);

}
