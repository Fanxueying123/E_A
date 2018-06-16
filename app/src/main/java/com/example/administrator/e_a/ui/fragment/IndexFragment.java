package com.example.administrator.e_a.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.e_a.R;
import com.example.administrator.e_a.adapter.NewsAdapter;
import com.example.administrator.e_a.bean.News;
import com.example.administrator.e_a.loader.GlideImageLoader;
import com.example.administrator.e_a.net.HttpResult;
import com.example.administrator.e_a.net.RetrofitUtil;
import com.example.administrator.e_a.util.Const;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class IndexFragment extends Fragment {
    private Banner mBanner;
    private RecyclerView mRecyclerView;
    private View mView;
    private List<String> mBannerImageUrl;
    private List<News> mNews;
    private NewsAdapter mNewsAdapter;
    public IndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_index, container, false);
        initView();
        init();
        return mView;
    }

    private void initView() {
        mBanner=(Banner)mView.findViewById(R.id.banner);
        mRecyclerView=(RecyclerView)mView.findViewById(R.id.recycler_view);
    }
    private void init(){
        mBannerImageUrl=new ArrayList<>();
        mBannerImageUrl.add(Const.NEWS_BANNER1);
        mBannerImageUrl.add(Const.NEWS_BANNER2);
        mBannerImageUrl.add(Const.NEWS_BANNER3);

        mBanner.setImages(mBannerImageUrl).setImageLoader(new GlideImageLoader()).start();

        mNews=new ArrayList<>();
        mNewsAdapter=new NewsAdapter(R.layout.item_view_news,mNews);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mNewsAdapter);

        RetrofitUtil.getNews(new Callback<HttpResult<List<News>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<News>>> call, Response<HttpResult<List<News>>> response) {
                mNewsAdapter.addData(response.body().getData());
            }

            @Override
            public void onFailure(Call<HttpResult<List<News>>> call, Throwable throwable) {

            }
        });
    }
}
