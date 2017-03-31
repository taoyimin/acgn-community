package com.taozi.twodimension.modules.news.i;

import com.taozi.twodimension.modules.news.bean.NewsBean;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Tao Yimin on 2017/3/13.
 */
public interface NewsServers {
    @GET("news")
    public Observable<List<NewsBean>> getNews();
}
