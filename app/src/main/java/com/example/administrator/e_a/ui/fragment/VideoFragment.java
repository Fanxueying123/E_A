package com.example.administrator.e_a.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.e_a.R;
import com.example.administrator.e_a.adapter.VideoAdapter;
import com.example.administrator.e_a.bean.Video;
import com.example.administrator.e_a.net.HttpResult;
import com.example.administrator.e_a.net.RetrofitUtil;
import com.example.administrator.e_a.ui.activity.VideoActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment implements BaseQuickAdapter.OnItemClickListener{
    private RecyclerView mRecyclerView;
    private View mView;

    private List<Video> mVideo;
    private VideoAdapter mVideoAdapter;

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_video, container, false);
        initView();
        init();
        return mView;
    }
    private void initView() {
        mRecyclerView=(RecyclerView)mView.findViewById(R.id.recycler_view);
    }
    private void init(){
        mVideo=new ArrayList<>();
        mVideoAdapter=new VideoAdapter(R.layout.item_view_video,mVideo);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mVideoAdapter);

        RetrofitUtil.getVideo(new Callback<HttpResult<List<Video>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<Video>>> call, Response<HttpResult<List<Video>>> response) {
                mVideoAdapter.addData(response.body().getData());
            }

            @Override
            public void onFailure(Call<HttpResult<List<Video>>> call, Throwable throwable) {

            }
        });

        mVideoAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Video video=(Video) baseQuickAdapter.getItem(i);

        Intent intent=new Intent(getContext(), VideoActivity.class);
        intent.putExtra("video_url",video.getUrl());
        intent.putExtra("video_name",video.getName());
        intent.putExtra("video_thumb_url",video.getVideoThumbUrl());
        startActivity(intent);
    }
}
