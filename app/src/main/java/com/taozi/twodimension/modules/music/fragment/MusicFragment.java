package com.taozi.twodimension.modules.music.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.taozi.twodimension.R;
import com.taozi.twodimension.fragment.BaseFragment;
import com.taozi.twodimension.modules.music.activity.SonglistDetailActivity;
import com.taozi.twodimension.modules.music.bean.SongListBean;
import com.taozi.twodimension.widget.BannerLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;

/**
 * Created by Tao Yimin on 2017/3/3.
 */
public class MusicFragment extends BaseFragment{

    @BindViews({R.id.songlist1,R.id.songlist2,R.id.songlist3,R.id.songlist4,R.id.songlist5,R.id.songlist6})
    List<ViewGroup> songlistCard;
    @BindViews({R.id.songlist1_image,R.id.songlist2_image,R.id.songlist3_image,R.id.songlist4_image,R.id.songlist5_image,R.id.songlist6_image})
    List<ImageView> songlistImage;
    @BindViews({R.id.songlist1_author,R.id.songlist2_author,R.id.songlist3_author,R.id.songlist4_author,R.id.songlist5_author,R.id.songlist6_author})
    List<TextView> songlistAuthor;
    @BindViews({R.id.songlist1_name,R.id.songlist2_name,R.id.songlist3_name,R.id.songlist4_name,R.id.songlist5_name,R.id.songlist6_name})
    List<TextView> songlistName;
    @BindViews({R.id.songlist1_playnumber,R.id.songlist2_playnumber,R.id.songlist3_playnumber,R.id.songlist4_playnumber,R.id.songlist5_playnumber,R.id.songlist6_playnumber})
    List<TextView> songlistPlaynumber;
    @BindView(R.id.music_scrollView)
    ObservableScrollView mScrollView;
    @BindView(R.id.music_banner)
    BannerLayout mBannerLayout;
    private List<BannerLayout.BannerEntity> urls = new ArrayList<>();
    private List<SongListBean> dataList=new ArrayList<>();

    public static MusicFragment newInstance() {
        return new MusicFragment();
    }

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_music_scrollview;
    }

    @Override
    protected void findViews(View view) {

    }

    @Override
    protected void initEvent() {
        mBannerLayout.setOnPagerClickListener(new BannerLayout.OnPagerClickListener() {
            @Override
            public void onClick(BannerLayout.BannerEntity entity) {
                Toast.makeText(getContext(),entity.getId()+"",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {
        urls.clear();
        SongListBean songListBean1=new SongListBean();
        songListBean1.setId(1);
        songListBean1.setAuthor("哈哈哈");
        songListBean1.setName("自己听吧");
        songListBean1.setImageUrl("http://i0.hdslb.com/bfs/archive/c18e3074dee76e7db88ca27df0026e2bf90fe283.jpg@.webp");
        songListBean1.setPlayNumber("1452");
        urls.add(songListBean1);
        SongListBean songListBean2=new SongListBean();
        songListBean2.setId(2);
        songListBean2.setAuthor("哈哈哈");
        songListBean2.setName("自己听吧");
        songListBean2.setImageUrl("http://p4.music.126.net/12BBNJYjxk2InB5T4O3vxA==/18506979720554609.jpg");
        songListBean2.setPlayNumber("1452");
        urls.add(songListBean2);
        mBannerLayout.setDatas(urls);

        SongListBean songListBean3=new SongListBean();
        songListBean3.setId(3);
        songListBean3.setAuthor("店长桐谷业");
        songListBean3.setName("【纯音】无歌词的静谧之森");
        songListBean3.setImageUrl("http://img3.imgtn.bdimg.com/it/u=524759939,1019657560&fm=23&gp=0.jpg");
        songListBean3.setPlayNumber("21");
        dataList.add(songListBean3);

        SongListBean songListBean4=new SongListBean();
        songListBean4.setId(4);
        songListBean4.setAuthor("幻神之瞳");
        songListBean4.setName("【日系】艳丽大方的魅力女音");
        songListBean4.setImageUrl("http://img4q.duitang.com/uploads/item/201505/02/20150502165407_VJrPh.jpeg");
        songListBean4.setPlayNumber("13");
        dataList.add(songListBean4);

        SongListBean songListBean5=new SongListBean();
        songListBean5.setId(5);
        songListBean5.setAuthor("人渣VIII");
        songListBean5.setName("自己听吧");
        songListBean5.setImageUrl("http://img3.duitang.com/uploads/item/201408/24/20140824201857_z2ifF.jpeg");
        songListBean5.setPlayNumber("422");
        dataList.add(songListBean5);

        SongListBean songListBean6=new SongListBean();
        songListBean6.setId(6);
        songListBean6.setAuthor("烟花酱");
        songListBean6.setName("【萌系】软妹音什么的无法抗拒呢");
        songListBean6.setImageUrl("http://cdnq.duitang.com/uploads/item/201502/06/20150206104235_cB8YV.jpeg");
        songListBean6.setPlayNumber("4221");
        dataList.add(songListBean6);

        SongListBean songListBean7=new SongListBean();
        songListBean7.setId(7);
        songListBean7.setAuthor("夜の灵の血色");
        songListBean7.setName("夜灵的元气治愈");
        songListBean7.setImageUrl("http://img4.duitang.com/uploads/blog/201310/24/20131024130051_V8Ph5.jpeg");
        songListBean7.setPlayNumber("1231");
        dataList.add(songListBean7);

        SongListBean songListBean8=new SongListBean();
        songListBean8.setId(8);
        songListBean8.setAuthor("淡清の茶");
        songListBean8.setName("【抒情】泪水的声音");
        songListBean8.setImageUrl("http://img0.imgtn.bdimg.com/it/u=2429785820,3322370324&fm=23&gp=0.jpg");
        songListBean8.setPlayNumber("131");
        dataList.add(songListBean8);

        updateData(dataList);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialViewPagerHelper.registerScrollView(getActivity(), mScrollView, null);
    }

    void updateData(final List<SongListBean> dataList){
        for (int i = 0; i < dataList.size(); i++) {
            SongListBean songListBean = dataList.get(i);
            Glide.with(this).load(songListBean.getImageUrl()).into(songlistImage.get(i));
            songlistName.get(i).setText(songListBean.getName());
            songlistAuthor.get(i).setText(songListBean.getAuthor());
            songlistPlaynumber.get(i).setText(songListBean.getPlayNumber());
            final int finalI = i;
            songlistCard.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), SonglistDetailActivity.class);
                    String imageUrl = dataList.get(finalI).getImageUrl();
                    intent.putExtra("imageUrl",imageUrl);
                    intent.putExtra("name",dataList.get(finalI).getName());
                    intent.putExtra("author",dataList.get(finalI).getAuthor());
                    intent.putExtra("imageWidth",songlistImage.get(finalI).getWidth());
                    intent.putExtra("imageHeight",songlistImage.get(finalI).getHeight());
                    //ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(getActivity(), Pair.create((View)(songlistImage.get(finalI)),"share_image"));
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
                }
            });
        }
    }

}
