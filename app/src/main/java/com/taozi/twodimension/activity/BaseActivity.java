package com.taozi.twodimension.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Tao Yimin on 2016/12/13.
 * 所有Activity的基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉actionBar
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(setContentViewId());
        unbinder=ButterKnife.bind(this);
        findViews();
        initEvent();
        init();
        loadData();
    }

    /**
     * 设置布局
     *
     * @return
     */
    protected abstract int setContentViewId();

    /**
     * 初始化控件
     */
    protected abstract void findViews();

    /**
     * 初始化事件
     */
    protected abstract void initEvent();

    /**
     * 初始化界面
     */
    protected abstract void init();

    /**
     * 加载数据
     */
    protected abstract void loadData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
