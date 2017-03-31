package com.taozi.twodimension.util;

import android.content.Context;
import android.os.Environment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.bumptech.glide.module.GlideModule;

import java.io.File;

/**
 * Created by Tao Yimin on 2016/12/17.
 * 配置Glide
 */
public class GlideModuleConfig implements GlideModule {

    @Override
    public void applyOptions(final Context context, GlideBuilder builder) {
        //设置图片的显示格式
        builder.setDecodeFormat(DecodeFormat.PREFER_RGB_565);
        String storagePath = "";
        //判断外部储存卡是否挂载
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            //如果外部储存卡处于挂载状态则使用外部储存卡
            storagePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            //如果外部储存卡处于非挂载状态则使用内部储存卡
            storagePath = Environment.getDataDirectory().getAbsolutePath();
        }
        final File cacheLocation = new File(storagePath+"/TwoDimension","imagecache");
        cacheLocation.mkdirs();
        builder .setDiskCache(new DiskCache.Factory() {
            @Override
            public DiskCache build() {
                return DiskLruCacheWrapper.get(cacheLocation, 100*1024*1024);
            }
        });
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
    }
}
