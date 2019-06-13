package com.ss.example.guoshuaishuaia.api;

import com.ss.example.guoshuaishuaia.bean.JokeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String mUrl="https://api.apiopen.top/";
    @GET("getJoke")
    Observable<JokeBean> getJoke();
}
