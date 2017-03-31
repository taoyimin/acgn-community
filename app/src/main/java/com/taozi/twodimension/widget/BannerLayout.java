package com.taozi.twodimension.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Scroller;

import com.bumptech.glide.Glide;
import com.taozi.twodimension.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tao Yimin on 2016/10/28.
 */
public class BannerLayout extends FrameLayout {

    ViewPager viewPager;
    LinearLayout linearLayout;
    GradientDrawable defaultDrawable,selectedDrawable;

    OnPagerClickListener onPagerClickListener;
    private List<BannerEntity> datas = new ArrayList<>();

    int size,gravity,startX, startY;
    boolean isPlaying;

    public interface OnPagerClickListener{

        void onClick(BannerEntity entity);
    }

    public interface BannerEntity{
        String getUrl();
        Integer getId();
    }

    private Handler handler = new Handler();

    private Runnable playTask = new  Runnable(){

        @Override
        public void run() {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            handler.postDelayed(this,4000);
        }
    };

    public BannerLayout(Context context) {
        this(context,null);
    }

    public BannerLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BannerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        size = (int) (6 * context.getResources().getDisplayMetrics().density + 0.5f);
        gravity = Gravity.CENTER;
        defaultDrawable = new GradientDrawable();
        defaultDrawable.setSize(size,size);
        defaultDrawable.setCornerRadius(size);
        defaultDrawable.setColor(0xffffffff);
        selectedDrawable = new GradientDrawable();
        selectedDrawable.setSize(size,size);
        selectedDrawable.setCornerRadius(size);
        selectedDrawable.setColor(getResources().getColor(R.color.colorAccent));

        viewPager = new ViewPager(context);
        LayoutParams vpLayoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        LayoutParams linearLayoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setGravity(gravity);
        linearLayout.setPadding(size * 2,size * 2,size * 2,size * 2);
        linearLayoutParams.gravity = Gravity.BOTTOM;
        addView(viewPager,vpLayoutParams);
        addView(linearLayout,linearLayoutParams);
        // 修改滚动速度
        Scroller scroller = new Scroller(context){
            @Override
            public void startScroll(int startX, int startY, int dx, int dy) {
                super.startScroll(startX, startY, dx, dy,3000);
            }

            @Override
            public void startScroll(int startX, int startY, int dx, int dy, int duration) {
                super.startScroll(startX, startY, dx, dy, 3000);
            }
        };

        try {
            Field field = viewPager.getClass().getDeclaredField("mScroller");
            field.setAccessible(true);
            field.set(viewPager, scroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 监听,切换圆点
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if(linearLayout != null && linearLayout.getChildCount() > 0){
                    int index = position % datas.size();
                    for (int i = 0; i < linearLayout.getChildCount(); i++) {
                        ((ImageView)linearLayout.getChildAt(i)).setImageDrawable(i == index ? selectedDrawable : defaultDrawable);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void setOnPagerClickListener(OnPagerClickListener onPagerClickListener) {
        this.onPagerClickListener = onPagerClickListener;
    }

    public synchronized void setPlaying(boolean playing){
        if(!isPlaying && playing && viewPager.getAdapter() != null && viewPager.getAdapter().getCount() > 2){
            handler.postDelayed(playTask,5000);
            isPlaying = true;
        }else if(isPlaying && !playing){
            handler.removeCallbacksAndMessages(null);
            isPlaying = false;
        }
    }

    public int setDatas(List<BannerEntity> datas){
        setPlaying(false);
        this.datas.clear();
        linearLayout.removeAllViews();
        if(datas != null){
            this.datas.addAll(datas);
        }
        viewPager.setAdapter(new BannerAdapter());
        if(this.datas.size() > 1){
            viewPager.setCurrentItem(this.datas.size() * 5000,false);
            for (int i = 0; i < this.datas.size(); i++) {
                ImageView img = new ImageView(getContext());
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.leftMargin = size/2;
                lp.rightMargin = size/2;
                img.setImageDrawable(i == 0 ? selectedDrawable : defaultDrawable);
                linearLayout.addView(img,lp);
            }
            setPlaying(true);
        }
        return this.datas.size();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = (int) ev.getX();
                startY = (int) ev.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
                setPlaying(false);
                break;
            case MotionEvent.ACTION_MOVE:
                int moveX = (int) ev.getX();
                int moveY = (int) ev.getY();
                int disX = moveX - startX;
                int disY = moveY - startY;
                getParent().requestDisallowInterceptTouchEvent(2 * Math.abs(disX) > Math.abs(disY));
                setPlaying(false);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                setPlaying(true);
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPlaying(true);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setPlaying(false);
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        if(visibility == View.GONE){
            // 停止轮播
            setPlaying(false);
        }else if(visibility == View.VISIBLE){
            // 开始轮播
            setPlaying(true);
        }
        super.onWindowVisibilityChanged(visibility);
    }
    // 内置适配器
    private class BannerAdapter extends PagerAdapter {private SparseArray<ImageView> imgs = new SparseArray<>();

        @Override
        public int getCount() {
            return datas == null ? 0 : datas.size() < 2 ? datas.size() : Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            final int p = position % datas.size();
            ImageView imageView = imgs.get(p);
            if(imageView == null){
                imageView = new ImageView(container.getContext());
                imageView.setLayoutParams(new ViewPager.LayoutParams());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imgs.put(p,imageView);
                imageView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(onPagerClickListener != null){
                            onPagerClickListener.onClick(datas.get(p));
                        }
                    }
                });
            }
            Glide.with(getContext()).load(datas.get(p).getUrl()).into(imageView);
            ViewParent parent = imageView.getParent();
            if(parent != null){
                ((ViewGroup)parent).removeView(imageView);
            }
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }
    }
}