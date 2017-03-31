package com.taozi.twodimension;

import android.app.Application;

import com.se7en.utils.DeviceUtils;

/**
 * Created by Tao Yimin on 2016/9/11.
 * 记得在清单文件注册!
 */
public class MyApplication extends Application {
    public static MyApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication=this;
        DeviceUtils.setContext(this);
    }

    public static MyApplication getIntstance() {
        return mApplication;
    }
}