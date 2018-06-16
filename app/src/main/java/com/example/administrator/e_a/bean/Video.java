package com.example.administrator.e_a.bean;

/**
 * Created by Administrator on 2018/6/12.
 */

public class Video {
    private int id;
    private String name;
    private String url;
    private String videoThumbUrl;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getVideoThumbUrl() {
        return videoThumbUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVideoThumbUrl(String videoThumbUrl) {
        this.videoThumbUrl = videoThumbUrl;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", videoThumbUrl='" + videoThumbUrl + '\'' +
                '}';
    }
}
