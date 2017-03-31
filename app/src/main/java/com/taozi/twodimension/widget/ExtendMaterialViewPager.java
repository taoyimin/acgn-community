package com.taozi.twodimension.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import com.github.florent37.materialviewpager.MaterialViewPager;

/**
 * Created by Tao Yimin on 2016/12/13.
 * 扩展的MaterialViewPager,修复了header快速滑动时的闪烁现象
 */
public class ExtendMaterialViewPager extends MaterialViewPager{
    int currentPagerState = Integer.MIN_VALUE;

    public ExtendMaterialViewPager(Context context) {
        super(context);
    }

    public ExtendMaterialViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExtendMaterialViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ExtendMaterialViewPager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (currentPagerState != ViewPager.SCROLL_STATE_SETTLING) {
            if (positionOffset >= 0.5) {
                onPageSelected(position + 1);
            } else if (positionOffset <= -0.5) {
                onPageSelected(position - 1);
            } else {
                onPageSelected(position);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        currentPagerState = state;
        super.onPageScrollStateChanged(state);
    }
}
