package com.taozi.twodimension.modules.animation.bean;

import com.taozi.twodimension.widget.BannerLayout;

/**
 * Created by Tao Yimin on 2017/2/27.
 */
public class AnimationBean implements BannerLayout.BannerEntity{
    Integer id;
    String title;//标题
    Integer progress;//更新进度
    String updataTime;//更新时间
    String imageUrl;//封面图片
    Integer episode;//总集
    String summary;//简介
    String bigImageUrl;//大图Url
    String state;//更新状态 连载or完结

    @Override
    public String getUrl() {
        return bigImageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public String getUpdataTime() {
        return updataTime;
    }

    public void setUpdataTime(String updataTime) {
        this.updataTime = updataTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBigImageUrl() {
        return bigImageUrl;
    }

    public void setBigImageUrl(String bigImageUrl) {
        this.bigImageUrl = bigImageUrl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

