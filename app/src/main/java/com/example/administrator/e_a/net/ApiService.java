package com.example.administrator.e_a.net;

import com.example.administrator.e_a.bean.News;
import com.example.administrator.e_a.bean.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018/6/12.
 */

public interface ApiService {
    @GET("getnews.php")
    Call<HttpResult<List<News>>> getNews();

    @GET("getvideo.php")
    Call<HttpResult<List<Video>>> getVideo();
}
