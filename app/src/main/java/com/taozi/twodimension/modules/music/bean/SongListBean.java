package com.taozi.twodimension.modules.music.bean;

import com.taozi.twodimension.widget.BannerLayout;

/**
 * Created by Tao Yimin on 2017/3/4.
 */
public class SongListBean implements BannerLayout.BannerEntity{
    Integer id;
    String name;
    String author;
    String playNumber;
    String imageUrl;

    @Override
    public String getUrl() {
        return imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPlayNumber() {
        return playNumber;
    }

    public void setPlayNumber(String playNumber) {
        this.playNumber = playNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
