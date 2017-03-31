package com.taozi.twodimension.modules.novel.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
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
import com.taozi.twodimension.modules.novel.activity.NovelDetailActivity;
import com.taozi.twodimension.modules.novel.bean.NovelBean;
import com.taozi.twodimension.widget.BannerLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;

/**
 * Created by Tao Yimin on 2017/3/7.
 */
public class NovelFragment extends BaseFragment{
    @BindView(R.id.novel_scrollView)
    ObservableScrollView mScrollView;
    @BindView(R.id.novel_banner)
    BannerLayout mBannerLayout;
    @BindViews({R.id.hot1, R.id.hot2, R.id.hot3, R.id.hot4, R.id.hot5, R.id.hot6})
    List<ViewGroup> hotLayouts;
    @BindViews({R.id.hot1_card, R.id.hot2_card, R.id.hot3_card, R.id.hot4_card, R.id
            .hot5_card, R.id.hot6_card})
    List<CardView> hotCards;
    @BindViews({R.id.hot1_image, R.id.hot2_image, R.id.hot3_image, R.id.hot4_image, R
            .id.hot5_image, R.id.hot6_image})
    List<ImageView> hotImages;
    @BindViews({R.id.hot1_name, R.id.hot2_name, R.id.hot3_name, R.id.hot4_name, R.id
            .hot5_name, R.id.hot6_name})
    List<TextView> hotNames;
    @BindViews({R.id.newbook1, R.id.newbook2, R.id.newbook3})
    List<ViewGroup> newbookLayouts;
    @BindViews({R.id.newbook1_card, R.id.newbook2_card, R.id.newbook3_card})
    List<CardView> newbookCards;
    @BindViews({R.id.newbook1_image, R.id.newbook2_image, R.id.newbook3_image})
    List<ImageView> newbookImages;
    @BindViews({R.id.newbook1_name, R.id.newbook2_name, R.id.newbook3_name})
    List<TextView> newbookNames;
    List<NovelBean> hotDatas = new ArrayList<>();
    List<NovelBean> newbookDatas = new ArrayList<>();
    private List<BannerLayout.BannerEntity> urls = new ArrayList<>();

    public static NovelFragment newInstance() {
        return new NovelFragment();
    }

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_novel_srcollview;
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
        urls.add(new Entity("http://rs.sfacg.com/web/m/images/homePush/2017/03/cdab7a02-a318-45e7-806e-b1bfb3c64218_big.jpg"));
        urls.add(new Entity("http://rs.sfacg.com/web/m/images/homePush/2017/03/0473eb61-840b-4eaf-a9ad-f6bace76d685_big.jpg"));
        urls.add(new Entity("http://rs.sfacg.com/web/m/images/homePush/2017/03/edd9d56d-13f8-4a2b-8e80-fe51063ecf59_big.jpg"));
        mBannerLayout.setDatas(urls);

        NovelBean novelBean1=new NovelBean();
        novelBean1.setId(1);
        novelBean1.setName("Fate：魔术师时代");
        novelBean1.setImageUrl("https://image.iqing.in/cover/387316bc-6bbe-4b42-99a5-bb4a259da163.jpg?imageView2/1/w/180/h/240/format/jpg/interlace/1/q/86");
        novelBean1.setChapter(10);
        novelBean1.setAuthor("哈哈");
        novelBean1.setProgress("第三卷");
        novelBean1.setSource("轻之文库");
        novelBean1.setStatue("连载");
        novelBean1.setSummary("打发手动阀手动阀打发士大夫士大夫似的地方士大夫士大夫士大夫似的手动阀手动阀打发士大夫士大夫士大夫似的是的粉色粉色的方式");
        hotDatas.add(novelBean1);

        NovelBean novelBean2=new NovelBean();
        novelBean2.setId(2);
        novelBean2.setName("三步町奇谭");
        novelBean2.setImageUrl("https://image.iqing.in/cover/aec22113-8557-4995-a0be-1bb30d8ea607.jpg?imageView2/1/w/180/h/240/format/jpg/interlace/1/q/86");
        novelBean2.setChapter(10);
        novelBean2.setAuthor("洱茶君");
        novelBean2.setProgress("第十卷");
        novelBean2.setSource("轻之文库");
        novelBean2.setStatue("连载");
        novelBean2.setSummary("芸芸众生皆有不等造化，因离死尚早，故惹下善与非善的种种因果。而后随业力流转，红颜化作白骨，次次轮回分作六个去处：天道、阿修罗道、人道、畜生道、饿鬼道、地狱道。 倘若此世道瞬间失了太平，阴阳沦落了虚妄。平安京内频频的异象疑云，人妖鬼神的命运却遵循着不知名的力量交织于一起。");
        hotDatas.add(novelBean2);

        NovelBean novelBean3=new NovelBean();
        novelBean3.setId(3);
        novelBean3.setName("蔷薇契约");
        novelBean3.setImageUrl("https://image.iqing.in/cover/09dacfd4-3afc-4f1f-8d19-0a9a1924f5d2.jpg?imageView2/1/w/180/h/240/format/jpg/interlace/1/q/86");
        novelBean3.setChapter(12);
        novelBean3.setAuthor("哈哈");
        novelBean3.setProgress("第三卷");
        novelBean3.setSource("轻之文库");
        novelBean3.setStatue("连载");
        novelBean3.setSummary("打发手动阀手动阀打发士大夫士大夫似的地方士大夫士大夫士大夫似的手动阀手动阀打发士大夫士大夫士大夫似的是的粉色粉色的方式");
        hotDatas.add(novelBean3);

        NovelBean novelBean4=new NovelBean();
        novelBean4.setId(4);
        novelBean4.setName("山田君与七个魔女");
        novelBean4.setImageUrl("https://imgsa.baidu.com/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=b9dc7887bc389b502cf2e800e45c8eb8/43a7d933c895d143224686ba76f082025aaf0772.jpg");
        novelBean4.setChapter(15);
        novelBean4.setAuthor("哈哈");
        novelBean4.setProgress("第三卷");
        novelBean4.setSource("轻之文库");
        novelBean4.setStatue("连载");
        novelBean4.setSummary("打发手动阀手动阀打发士大夫士大夫似的地方士大夫士大夫士大夫似的手动阀手动阀打发士大夫士大夫士大夫似的是的粉色粉色的方式");
        hotDatas.add(novelBean4);

        NovelBean novelBean5=new NovelBean();
        novelBean5.setId(5);
        novelBean5.setName("为美好的世界献上祝福");
        novelBean5.setImageUrl("http://img3.imgtn.bdimg.com/it/u=3726316112,3623517473&fm=11&gp=0.jpg");
        novelBean5.setChapter(14);
        novelBean5.setAuthor("哈哈");
        novelBean5.setProgress("第三卷");
        novelBean5.setSource("轻之文库");
        novelBean5.setStatue("连载");
        novelBean5.setSummary("打发手动阀手动阀打发士大夫士大夫似的地方士大夫士大夫士大夫似的手动阀手动阀打发士大夫士大夫士大夫似的是的粉色粉色的方式");
        hotDatas.add(novelBean5);

        NovelBean novelBean6=new NovelBean();
        novelBean6.setId(6);
        novelBean6.setName("从零开始的异世界生活");
        novelBean6.setImageUrl("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3022818594,2957573905&fm=23&gp=0.jpg");
        novelBean6.setChapter(12);
        novelBean6.setAuthor("哈哈");
        novelBean6.setProgress("第三卷");
        novelBean6.setSource("轻之文库");
        novelBean6.setStatue("连载");
        novelBean6.setSummary("打发手动阀手动阀打发士大夫士大夫似的地方士大夫士大夫士大夫似的手动阀手动阀打发士大夫士大夫士大夫似的是的粉色粉色的方式");
        hotDatas.add(novelBean6);
        updateData(hotLayouts,hotCards,hotNames,hotImages,hotDatas);

        NovelBean novelBean7=new NovelBean();
        novelBean7.setId(7);
        novelBean7.setName("克莉丝的炎之信仰");
        novelBean7.setImageUrl("https://image.iqing.in/cover/9b3daf24-404d-4d49-aa6f-6ca49d047ea8.jpg?imageView2/1/w/180/h/240/format/jpg/interlace/1/q/86");
        novelBean7.setChapter(12);
        novelBean7.setAuthor("哈哈");
        novelBean7.setProgress("第三卷");
        novelBean7.setSource("轻之文库");
        novelBean7.setStatue("连载");
        novelBean7.setSummary("打发手动阀手动阀打发士大夫士大夫似的地方士大夫士大夫士大夫似的手动阀手动阀打发士大夫士大夫士大夫似的是的粉色粉色的方式");
        newbookDatas.add(novelBean7);

        NovelBean novelBean8=new NovelBean();
        novelBean8.setId(8);
        novelBean8.setName(" 一派之长为老不尊！");
        novelBean8.setImageUrl("https://image.iqing.in/cover/a0d19177-c42f-4fc5-9377-5b52a40dfd5f.jpg?imageView2/1/w/180/h/240/format/jpg/interlace/1/q/86");
        novelBean8.setChapter(12);
        novelBean8.setAuthor("哈哈");
        novelBean8.setProgress("第三卷");
        novelBean8.setSource("轻之文库");
        novelBean8.setStatue("连载");
        novelBean8.setSummary("打发手动阀手动阀打发士大夫士大夫似的地方士大夫士大夫士大夫似的手动阀手动阀打发士大夫士大夫士大夫似的是的粉色粉色的方式");
        newbookDatas.add(novelBean8);

        NovelBean novelBean9=new NovelBean();
        novelBean9.setId(9);
        novelBean9.setName("好不容易出生在魔法世家的我却是个普通人？");
        novelBean9.setImageUrl("https://image.iqing.in/cover/fbf30538-06b1-45cf-9b17-d1b8e6cdc6a5.png?imageView2/1/w/180/h/240/format/jpg/interlace/1/q/86");
        novelBean9.setChapter(12);
        novelBean9.setAuthor("哈哈");
        novelBean9.setProgress("第三卷");
        novelBean9.setSource("轻之文库");
        novelBean9.setStatue("连载");
        novelBean9.setSummary("打发手动阀手动阀打发士大夫士大夫似的地方士大夫士大夫士大夫似的手动阀手动阀打发士大夫士大夫士大夫似的是的粉色粉色的方式");
        newbookDatas.add(novelBean9);
        updateData(newbookLayouts,newbookCards,newbookNames,newbookImages,newbookDatas);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialViewPagerHelper.registerScrollView(getActivity(), mScrollView, null);
    }

    void updateData(List<ViewGroup> layoutList, final List<CardView> cardList,
                    List<TextView> nameList,  final List<ImageView>
                            imageList, final List<NovelBean> dataList){
        for (int i = 0; i < dataList.size(); i++) {
            NovelBean novelBean = dataList.get(i);
            Glide.with(this).load(novelBean.getImageUrl()).into(imageList.get(i));
            nameList.get(i).setText(novelBean.getName());
            final int finalI = i;
            layoutList.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), NovelDetailActivity.class);
                    intent.putExtra("imageUrl",dataList.get(finalI).getImageUrl());
                    intent.putExtra("name",dataList.get(finalI).getName());
                    intent.putExtra("author",dataList.get(finalI).getAuthor());
                    intent.putExtra("progress",dataList.get(finalI).getProgress());
                    intent.putExtra("source",dataList.get(finalI).getSource());
                    intent.putExtra("statue",dataList.get(finalI).getStatue());
                    intent.putExtra("chapter",dataList.get(finalI).getChapter());
                    intent.putExtra("summary",dataList.get(finalI).getSummary());
                    startActivity(intent, ActivityOptions
                            .makeSceneTransitionAnimation(getActivity()).toBundle());
                }
            });
        }
    }

    private class Entity implements BannerLayout.BannerEntity {

        String url;
        Integer id;

        public Entity(String url) {
            this.url = url;
        }

        @Override
        public String getUrl() {
            return url;
        }

        @Override
        public Integer getId() {
            return id;
        }
    }
}
