package com.example.git_text;

import com.example.git_text.bean.MeiNvBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {

    //http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1
    public String Url = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/";
    @GET("20/1")
    Observable<MeiNvBean> getMeiNv();
}
