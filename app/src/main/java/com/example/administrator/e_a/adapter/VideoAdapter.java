package com.example.administrator.e_a.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.e_a.R;
import com.example.administrator.e_a.bean.Video;

import java.util.List;

/**
 * Created by Administrator on 2018/6/12.
 */

public class VideoAdapter extends BaseQuickAdapter<Video,BaseViewHolder> {
    public VideoAdapter(@LayoutRes int layoutResId, @Nullable List<Video> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Video video) {
        baseViewHolder.setText(R.id.tv_video_name,video.getName());
        Glide.with(mContext).load(video.getVideoThumbUrl()).into((ImageView)baseViewHolder.getView(R.id.video_thumb));
    }
}
