package com.taozi.twodimension.i;

import com.taozi.twodimension.bean.Hots;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Tao Yimin on 2017/3/23.
 */
public interface HotsServers {
    @GET("hots")
    public Observable<List<Hots>> getHots();
}
