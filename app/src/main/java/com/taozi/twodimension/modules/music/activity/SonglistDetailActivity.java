package com.taozi.twodimension.modules.music.activity;

import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.se7en.utils.DeviceUtils;
import com.taozi.twodimension.R;
import com.taozi.twodimension.activity.BaseActivity;
import com.taozi.twodimension.modules.music.adatper.SonglistRecyclerViewAdapter;
import com.taozi.twodimension.modules.music.bean.SongBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Tao Yimin on 2017/3/4.
 */
public class SonglistDetailActivity extends BaseActivity {
    @BindView(R.id.songlist_recycler)
    RecyclerView recyclerView;
    @BindView(R.id.songlist_image)
    ImageView imageView;
    SonglistRecyclerViewAdapter mAdapter;
    List<SongBean> dataList = new ArrayList<>();

    @Override
    protected int setContentViewId() {
        return R.layout.activity_songlist_detail;
    }

    @Override
    protected void findViews() {

    }

    @Override
    protected void initEvent() {
    }

    @Override
    protected void init() {
        String imageUrl = getIntent().getStringExtra("imageUrl");
        int imageWidth = getIntent().getIntExtra("imageWidth", 1);
        int imageHeight = getIntent().getIntExtra("imageHeight", 1);
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.height = DeviceUtils.getScreenWdith() * imageHeight / imageWidth;
        imageView.setLayoutParams(params);
        Glide.with(this).load(imageUrl).into(imageView);
        mAdapter = new SonglistRecyclerViewAdapter(this, dataList);
        mAdapter.setHeadInitListener(new SonglistRecyclerViewAdapter.HeadInitListener() {
            @Override
            public void headInit(final SonglistRecyclerViewAdapter.SongHeadViewHolder holder) {
                holder.tagGroup.setTags(new String[]{"纯音乐", "日系", "安静", "小清新"});
                Glide.with(SonglistDetailActivity.this).load("http://img2.imgtn.bdimg.com/it/u=2337698855,2476434391&fm=23&gp=0.jpg").asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(SonglistDetailActivity.this.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        holder.imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void loadData() {
        dataList.add(new SongBean());
        SongBean songBean1 = new SongBean();
        songBean1.setId(1);
        songBean1.setName("あの日の記憶");
        songBean1.setSpecial("TVアニメーション「終末のイゼッタ」オリジナルサウンドトラック");
        songBean1.setImageUrl("https://ss0.baidu.com/73x1bjeh1BF3odCf/it/u=448365208,189006674&fm=85&s=A00462B4C04220EE90346921030070D2");
        dataList.add(songBean1);

        SongBean songBean2 = new SongBean();
        songBean2.setId(2);
        songBean2.setName("儚月に想いを驰せる");
        songBean2.setSpecial("丽 −RAY− 月天夜姫");
        songBean2.setImageUrl("https://ss0.baidu.com/73x1bjeh1BF3odCf/it/u=3826210306,3979386383&fm=85&s=9812EA17324277ED452D65F50300E022");
        dataList.add(songBean2);

        SongBean songBean3 = new SongBean();
        songBean3.setId(3);
        songBean3.setName("棘");
        songBean3.setSpecial("虚ノ少女 オリジナルサウンドトラック");
        songBean3.setImageUrl("https://ss0.baidu.com/73t1bjeh1BF3odCf/it/u=2174054708,1549044257&fm=85&s=9184BC5D6C135C4D3E3D7C0903003012");
        dataList.add(songBean3);

        SongBean songBean4 = new SongBean();
        songBean4.setId(4);
        songBean4.setName("月笹舟");
        songBean4.setSpecial("涼風至");
        songBean4.setImageUrl("https://ss0.baidu.com/73x1bjeh1BF3odCf/it/u=3655071154,599553380&fm=85&s=C080FD1C578276E64858D1DB0300C0B1");
        dataList.add(songBean4);

        SongBean songBean5 = new SongBean();
        songBean5.setId(5);
        songBean5.setName("メイドと花のバスケット");
        songBean5.setSpecial("メイドと花のバスケット");
        songBean5.setImageUrl("https://ss0.baidu.com/73x1bjeh1BF3odCf/it/u=1846965556,1676544866&fm=85&s=A4E86EB65FA3EECC56271A740300507C");
        dataList.add(songBean5);

        mAdapter.notifyDataSetChanged();
    }
}
