package com.taozi.twodimension.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.taozi.twodimension.bean.Hots;

import java.util.List;

/**
 * Created by Tao Yimin on 2017/3/23.
 */
public class GradientTextView extends TextView{
    private List<Hots> dataList;

    public GradientTextView(Context context) {
        this(context,null);
    }

    public GradientTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public GradientTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDataList(List<Hots> dataList) {
        this.dataList = dataList;
    }

    public void changeText(final int index){
        if(dataList==null){
            return;
        }
        clearAnimation();
        ObjectAnimator animator=ObjectAnimator.ofFloat(this,"alpha",1f,0f,1f);
        animator.setDuration(100);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float progress=animation.getAnimatedFraction();
                if(progress==0.5){
                    setText(dataList.get(index).getTitle().replace("\\n", "\n"));
                }
            }
        });
        animator.start();
    }
}
