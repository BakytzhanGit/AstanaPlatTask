package com.example.bakytzhan.astanaplattask;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.bakytzhan.astanaplattask.API.ApiClient;
import com.example.bakytzhan.astanaplattask.API.ApiService;
import com.tomtom.online.sdk.common.location.LatLng;
import com.tomtom.online.sdk.map.Icon;
import com.tomtom.online.sdk.map.MapFragment;
import com.tomtom.online.sdk.map.MapView;
import com.tomtom.online.sdk.map.Marker;
import com.tomtom.online.sdk.map.MarkerAnchor;
import com.tomtom.online.sdk.map.MarkerBuilder;
import com.tomtom.online.sdk.map.OnMapReadyCallback;
import com.tomtom.online.sdk.map.SimpleMarkerBalloon;
import com.tomtom.online.sdk.map.TomtomMap;
import com.tomtom.online.sdk.map.TomtomMapCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private ApiService apiService;
    private TomtomMap tomtomMap;

    private List<SinglePlace> listPalaces = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_fragment);
        mapFragment.getAsyncMap(this);

        String body = "<Request><Type>postpoint.getList</Type></Request>";

        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), body);

        apiService = ApiClient.getPlaces_retrofit().create(ApiService.class);

        apiService.getPlaces(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<PlacesResp>() {
                    @Override
                    public void onSuccess(PlacesResp resp) {
                        Log.e("rx_log", "OnSuccess");
                        Log.e("rx_log",  "onSuccess: " + resp.getErrMsg());
                        Log.e("rx_log",  "onSuccess: " + resp.getPlaceList().size());

                        listPalaces.addAll(resp.getPlaceList());

                        for (int i = 0; i < listPalaces.size(); i++){
                            if(listPalaces.get(i).getLatitude() == null ){
                                Log.e("rx_log", "Latitude is null, position: " + i);
                            }
                            else if(listPalaces.get(i).getLongitude() == null){
                                Log.e("rx_log", "Longitude is null, position: " + i);
                            }else {
                                double latitude = listPalaces.get(i).getLatitude();
                                double longitude = listPalaces.get(i).getLongitude();
                                LatLng position = new LatLng(latitude,longitude);
                                SimpleMarkerBalloon balloon = new SimpleMarkerBalloon(
                                        "Город: " + listPalaces.get(i).getCity() + "\n" +
                                        "Адрес: " + listPalaces.get(i).getAddress() + "\n" +
                                        "Имя: " + listPalaces.get(i).getName());

                                tomtomMap.addMarker(new MarkerBuilder(position).markerBalloon(balloon));
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("rx_log", "OnError " + e.toString());
                    }
                });
    }

    @Override
    public void onMapReady(@android.support.annotation.NonNull TomtomMap tomtomMap) {
        this.tomtomMap = tomtomMap;
        tomtomMap.setMyLocationEnabled(true);
        tomtomMap.setLanguage(Locale.getDefault().getLanguage());

    }
}
