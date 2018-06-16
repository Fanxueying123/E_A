package com.example.administrator.e_a.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.e_a.R;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoActivity extends AppCompatActivity {
    private JZVideoPlayerStandard mJZVideoPlayerStandard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();
        init();
    }

    private void initView() {
        mJZVideoPlayerStandard=(JZVideoPlayerStandard)findViewById(R.id.video_player);
    }
    private void init(){
        Intent intent=getIntent();
        String videoName=intent.getStringExtra("video_name");
        String videoUrl=intent.getStringExtra("video_url");
        //String videoThumbUrl=intent.getStringExtra("video_thumb_url");

        mJZVideoPlayerStandard.setUp(videoUrl, JZVideoPlayer.SCREEN_WINDOW_NORMAL,videoName);
    }
    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}
