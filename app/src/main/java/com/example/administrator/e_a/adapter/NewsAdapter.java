package com.example.administrator.e_a.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.e_a.R;
import com.example.administrator.e_a.bean.News;

import java.util.List;

/**
 * Created by Administrator on 2018/6/12.
 */

public class NewsAdapter extends BaseQuickAdapter<News,BaseViewHolder> {
    public NewsAdapter(@LayoutRes int layoutResId, @Nullable List<News> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, News news) {
        baseViewHolder.setText(R.id.news_title,news.getTitle());
        baseViewHolder.setText(R.id.news_content,news.getContent());

        Glide.with(mContext).load(news.getImageUrl()).into((ImageView) baseViewHolder.getView(R.id.news_thumb));
    }
}
