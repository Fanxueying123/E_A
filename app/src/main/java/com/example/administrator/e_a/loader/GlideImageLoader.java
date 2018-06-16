package com.example.administrator.e_a.loader;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Administrator on 2018/6/12.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object o, ImageView imageView) {
        Glide.with(context).load(o).into(imageView);
    }
}
