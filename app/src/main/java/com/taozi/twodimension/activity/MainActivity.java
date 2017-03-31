package com.taozi.twodimension.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.taozi.twodimension.R;
import com.taozi.twodimension.bean.Hots;
import com.taozi.twodimension.fragment.RecyclerViewFragment;
import com.taozi.twodimension.i.HotsServers;
import com.taozi.twodimension.modules.animation.fragment.AnimationFragment;
import com.taozi.twodimension.modules.music.fragment.MusicFragment;
import com.taozi.twodimension.modules.news.fragment.NewsFragment;
import com.taozi.twodimension.modules.novel.fragment.NovelFragment;
import com.taozi.twodimension.util.Constants;
import com.taozi.twodimension.widget.GradientTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends DrawerActivity {
    @BindView(R.id.materialViewPager)
    MaterialViewPager mMaterialViewPager;
    Toolbar mToolbar;
/*    @Nullable
    @BindView(R.id.logo_white)
    View mLogoView;*/
    @BindView(R.id.logo_text)
    GradientTextView logoText;
    private List<Hots> dataList=new ArrayList<>();

    @Override
    protected int setContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViews() {
        mToolbar = mMaterialViewPager.getToolbar();
    }

    @Override
    protected void initEvent() {
        //getWindow().setExitTransition(new Slide(Gravity.RIGHT));
        //设置mMaterialViewPager中viewpager的适配器
        mMaterialViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter
                (getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 4) {
                    case 0:
                        return NewsFragment.newInstance();
                    case 1:
                        return AnimationFragment.newInstance();
                    case 2:
                        return MusicFragment.newInstance();
                    case 3:
                        return NovelFragment.newInstance();
                    default:
                        return RecyclerViewFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
                    case 0:
                        return "资      讯";
                    case 1:
                        return "番      剧";
                    case 2:
                        return "音      乐";
                    case 3:
                        return "小      说";
                }
                return "";
            }
        });
        //设置mMaterialViewPager的Header颜色与背景图片
/*        mMaterialViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorNews,
                                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489562389141&di=1eb04aaa90afd7f91e649f2b7b940edb&imgtype=0&src=http%3A%2F%2Fh5.86.cc%2Fwalls%2F20140721%2F1440x900_c834be24a72575d.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorAnime,
                                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489411106707&di=2d8956adf24aa6c126b42ed9f3a7dd9b&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farchive%2Fb4b4f5f86debb9f42d5b734b1d41215e53bb305f.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorMusic,
                                "http://cdn.acgjc.com/wp-content/uploads/2016/10/00834f17c0ea49c57f5dd345e786321b-1024x647.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorNovel,
                                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489577141112&di=877dd21927f51e922b41fb9bf5370a01&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2F6e3d3ab3613b576f67d11cb1250db4655ae7253b.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });*/
        mMaterialViewPager.getViewPager().addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                logoText.changeText(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //设置缓存个数
        mMaterialViewPager.getViewPager().setOffscreenPageLimit(mMaterialViewPager.getViewPager()
                .getAdapter().getCount());
        mMaterialViewPager.getPagerTitleStrip().setViewPager(mMaterialViewPager.getViewPager());
        //去除viewpager滑到尽头的阴影
        mMaterialViewPager.getViewPager().setOverScrollMode(View.OVER_SCROLL_NEVER);
    }

    @Override
    protected void init() {
        //将toolbar的title设为""
        setTitle("");
        //用toolbar取代actionbar
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
    }

    @Override
    protected void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        HotsServers hotsServers = retrofit.create(HotsServers.class);
        Observable<List<Hots>> observable=hotsServers.getHots();
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Hots>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(List<Hots> newsBeen) {
                        dataList=newsBeen;
                        updateHeader();
                        mMaterialViewPager.onPageScrolled(0,0,1);
                        logoText.setDataList(dataList);
                        logoText.setText(dataList.get(0).getTitle());
                        //mMaterialViewPager.notifyHeaderChanged();
                    }
                });
    }

    public void updateHeader(){
        mMaterialViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorNews,dataList.get(page).getImageUrl()
                                );
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorAnime,
                                dataList.get(page).getImageUrl());
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorMusic,
                                dataList.get(page).getImageUrl());
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.colorNovel,
                                dataList.get(page).getImageUrl());
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });
    }

    @Optional
    @OnClick(R.id.logo_text)
    public void onLogoClick(View view) {
        mMaterialViewPager.notifyHeaderChanged();
        Toast.makeText(this, "The title is clicked!", Toast
                .LENGTH_SHORT).show();
    }
}
