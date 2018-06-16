package com.example.administrator.e_a.net;

import com.example.administrator.e_a.bean.News;
import com.example.administrator.e_a.bean.Video;
import com.example.administrator.e_a.util.Const;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/6/12.
 */

public class RetrofitUtil {
    public static void getNews(Callback<HttpResult<List<News>>> callback){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService=retrofit.create(ApiService.class);

        Call<HttpResult<List<News>>> call=apiService.getNews();

        call.enqueue(callback);
     }
    public static void getVideo(Callback<HttpResult<List<Video>>> callback){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService=retrofit.create(ApiService.class);

        Call<HttpResult<List<Video>>> call=apiService.getVideo();

        call.enqueue(callback);
    }
}
