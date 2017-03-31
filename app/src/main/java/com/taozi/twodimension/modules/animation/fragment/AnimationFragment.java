package com.taozi.twodimension.modules.animation.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.Pair;
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
import com.taozi.twodimension.modules.animation.activity.AnimationDetailActivity;
import com.taozi.twodimension.modules.animation.bean.AnimationBean;
import com.taozi.twodimension.widget.BannerLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;

/**
 * Created by Tao Yimin on 2016/12/13.
 */
public class AnimationFragment extends BaseFragment {
    @BindView(R.id.animation_scrollView)
    ObservableScrollView mScrollView;
    @BindView(R.id.animation_banner)
    BannerLayout mBannerLayout;
    @BindViews({R.id.xinfan1, R.id.xinfan2, R.id.xinfan3, R.id.xinfan4, R.id.xinfan5, R.id.xinfan6})
    List<ViewGroup> xinfanLayouts;
    @BindViews({R.id.xinfan1_card, R.id.xinfan2_card, R.id.xinfan3_card, R.id.xinfan4_card, R.id
            .xinfan5_card, R.id.xinfan6_card})
    List<CardView> xinfanCards;
    @BindViews({R.id.xinfan1_image, R.id.xinfan2_image, R.id.xinfan3_image, R.id.xinfan4_image, R
            .id.xinfan5_image, R.id.xinfan6_image})
    List<ImageView> xinfanImages;
    @BindViews({R.id.xinfan1_name, R.id.xinfan2_name, R.id.xinfan3_name, R.id.xinfan4_name, R.id
            .xinfan5_name, R.id.xinfan6_name})
    List<TextView> xinfanNames;
    @BindViews({R.id.xinfan1_progress, R.id.xinfan2_progress, R.id.xinfan3_progress, R.id
            .xinfan4_progress, R.id.xinfan5_progress, R.id.xinfan6_progress})
    List<TextView> xinfanProgress;
    @BindViews({R.id.guochan1, R.id.guochan2, R.id.guochan3})
    List<ViewGroup> guochanLayouts;
    @BindViews({R.id.guochan1_card, R.id.guochan2_card, R.id.guochan3_card})
    List<CardView> guochanCards;
    @BindViews({R.id.guochan1_image, R.id.guochan2_image, R.id.guochan3_image})
    List<ImageView> guochanImages;
    @BindViews({R.id.guochan1_name, R.id.guochan2_name, R.id.guochan3_name})
    List<TextView> guochanNames;
    @BindViews({R.id.guochan1_progress, R.id.guochan2_progress, R.id.guochan3_progress})
    List<TextView> guochanProgress;
    @BindViews({R.id.fenji1, R.id.fenji2, R.id.fenji3})
    List<ViewGroup> fenjiLayouts;
    @BindViews({R.id.fenji1_card, R.id.fenji2_card, R.id.fenji3_card})
    List<CardView> fenjiCards;
    @BindViews({R.id.fenji1_image, R.id.fenji2_image, R.id.fenji3_image})
    List<ImageView> fenjiImages;
    @BindViews({R.id.fenji1_name, R.id.fenji2_name, R.id.fenji3_name})
    List<TextView> fenjiNames;
    @BindViews({R.id.fenji1_progress, R.id.fenji2_progress, R.id.fenji3_progress})
    List<TextView> fenjiProgress;
    @BindViews({R.id.tuijian1, R.id.tuijian2, R.id.tuijian3, R.id.tuijian4, R.id.tuijian5})
    List<ViewGroup> tuijianLayouts;
    @BindViews({R.id.tuijian1_image, R.id.tuijian2_image, R.id.tuijian3_image, R.id
            .tuijian4_image, R
            .id.tuijian5_image})
    List<ImageView> tuijianImages;
    @BindViews({R.id.tuijian1_name, R.id.tuijian2_name, R.id.tuijian3_name, R.id.tuijian4_name, R.id
            .tuijian5_name})
    List<TextView> tuijianNames;
    @BindViews({R.id.tuijian1_summary, R.id.tuijian2_summary, R.id.tuijian3_summary, R.id
            .tuijian4_summary, R.id.tuijian5_summary})
    List<TextView> tuijianSummary;
    List<AnimationBean> xinfanDatas = new ArrayList<>();
    List<AnimationBean> guochanDatas = new ArrayList<>();
    List<AnimationBean> fenjiDatas = new ArrayList<>();
    List<AnimationBean> tuijianDatas = new ArrayList<>();
    private List<BannerLayout.BannerEntity> urls = new ArrayList<>();

    public static AnimationFragment newInstance() {
        return new AnimationFragment();
    }

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_animation_scrollview;
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
        AnimationBean animationBean000=new AnimationBean();
        animationBean000.setBigImageUrl("http://i0.hdslb.com/bfs/bangumi/16e078e66b41da3dbe26addf4d8f20801ef90398.jpg_620x300.jpg");
        animationBean000.setId(000);
        urls.add(animationBean000);
        AnimationBean animationBean111=new AnimationBean();
        animationBean111.setBigImageUrl("http://i0.hdslb.com/bfs/bangumi/71bdd818272db6e866c260abb8de58aad1fef59a.jpg_620x300.jpg");
        animationBean111.setId(111);
        urls.add(animationBean111);
        AnimationBean animationBean222=new AnimationBean();
        animationBean222.setBigImageUrl("http://i0.hdslb.com/bfs/bangumi/133306c8313323d568b6267037798cbb6c55a3c7.jpg_620x300.jpg");
        animationBean222.setId(222);
        urls.add(animationBean222);
        AnimationBean animationBean333=new AnimationBean();
        animationBean333.setBigImageUrl("http://i0.hdslb.com/bfs/bangumi/18ba9c7bc5a578c1e00f30d83d5297ce297abbe8.jpg_620x300.jpg");
        animationBean333.setId(333);
        urls.add(animationBean333);
        mBannerLayout.setDatas(urls);

        AnimationBean animationBean1 = new AnimationBean();
        animationBean1.setTitle("小林家的龙女仆");
        animationBean1.setProgress(7);
        animationBean1.setUpdataTime("每周一更新");
        animationBean1.setState("连载中");
        animationBean1.setEpisode(12);
        animationBean1.setSummary("就嘎疯狂进攻i罚款给你介绍考虑推荐上课时间航空技术的方式搭街坊四道口是搭街坊士大夫");
        animationBean1.setImageUrl("http://pic.80dyy" +
                ".net:8080/pic/uploadimg/2017-1/20170112025455255525.jpg");
        xinfanDatas.add(animationBean1);
        AnimationBean animationBean2 = new AnimationBean();
        animationBean2.setTitle("Rewrite 2nd Season");
        animationBean2.setProgress(20);
        animationBean2.setUpdataTime("每周一更新");
        animationBean2.setState("连载中");
        animationBean2.setEpisode(24);
        animationBean2.setSummary("就嘎疯狂进攻i罚款给你介绍考虑推荐上课时间航空技术的方式搭街坊四道口是搭街坊士大夫");
        animationBean2.setImageUrl("https://timgsa.baidu" +
                ".com/timg?image&quality=80&size=b9999_10000&sec=1488194071897&di" +
                "=4d744c406c8ee6d5391393127ebd5bcf&imgtype=0&src=http%3A%2F%2Fi-3.pp8" +
                ".com%2F2017%2F2%2F16%2F3ea04b8f-5cff-408f-a4a6-43623c3e40cd.jpg");
        xinfanDatas.add(animationBean2);
        AnimationBean animationBean3 = new AnimationBean();
        animationBean3.setTitle("3月的狮子");
        animationBean3.setProgress(19);
        animationBean3.setUpdataTime("每周三更新");
        animationBean3.setState("连载中");
        animationBean3.setEpisode(12);
        animationBean3.setSummary("就嘎疯狂进攻i罚款给你介绍考虑推荐上课时间航空技术的方式搭街坊四道口是搭街坊士大夫");
        animationBean3.setImageUrl("https://ss3.bdstatic" +
                ".com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4053859121,3912068912&fm=11&gp=0.jpg");
        xinfanDatas.add(animationBean3);
        AnimationBean animationBean4 = new AnimationBean();
        animationBean4.setTitle("锁链战记 赫克瑟塔斯之光");
        animationBean4.setProgress(3);
        animationBean4.setUpdataTime("每周五更新");
        animationBean4.setState("连载中");
        animationBean4.setEpisode(18);
        animationBean4.setSummary("就嘎疯狂进攻i罚款给你介绍考虑推荐上课时间航空技术的方式搭街坊四道口是搭街坊士大夫");
        animationBean4.setImageUrl("https://timgsa.baidu" +
                ".com/timg?image&quality=80&size=b9999_10000&sec=1488194191209&di" +
                "=eaa302027c0d13325f826564360b4ea6&imgtype=0&src=http%3A%2F%2Fwww.520885" +
                ".com%2Fpic%2Fuploadimg%2F2017-1%2F20171811275079780.png");
        xinfanDatas.add(animationBean4);
        AnimationBean animationBean5 = new AnimationBean();
        animationBean5.setTitle("风夏");
        animationBean5.setProgress(20);
        animationBean5.setUpdataTime("每周六更新");
        animationBean5.setState("连载中");
        animationBean5.setEpisode(26);
        animationBean5.setSummary("就嘎疯狂进攻i罚款给你介绍考虑推荐上课时间航空技术的方式搭街坊四道口是搭街坊士大夫");
        animationBean5.setImageUrl("https://timgsa.baidu" +
                ".com/timg?image&quality=80&size=b9999_10000&sec=1488194243456&di" +
                "=261852f9c4b7bfad6b9609c077e3f782&imgtype=0&src=http%3A%2F%2Fimgwx2.2345" +
                ".com%2Fdypcimg%2Fdongman%2Fimg%2Fe%2F24%2Fsup74634.jpg");
        xinfanDatas.add(animationBean5);
        AnimationBean animationBean6 = new AnimationBean();
        animationBean6.setTitle("清恋");
        animationBean6.setProgress(8);
        animationBean6.setUpdataTime("每周日更新");
        animationBean6.setState("连载中");
        animationBean6.setEpisode(12);
        animationBean6.setSummary("就嘎疯狂进攻i罚款给你介绍考虑推荐上课时间航空技术的方式搭街坊四道口是搭街坊士大夫");
        animationBean6.setImageUrl("https://timgsa.baidu" +
                ".com/timg?image&quality=80&size=b9999_10000&sec=1488194418137&di" +
                "=29030d2f3f8f310d0d1f26cfc0e6ea6d&imgtype=0&src=http%3A%2F%2Fimg2.gyjlm" +
                ".com%2Fimages%2Fimg201509%2F20171613185486700.jpg");
        xinfanDatas.add(animationBean6);
        updateData(xinfanLayouts, xinfanCards, xinfanNames, xinfanProgress, xinfanImages,
                xinfanDatas);

        AnimationBean animationBean7 = new AnimationBean();
        animationBean7.setTitle("斗破苍穹");
        animationBean7.setProgress(5);
        animationBean7.setUpdataTime("每周二更新");
        animationBean7.setState("连载中");
        animationBean7.setEpisode(24);
        animationBean7.setSummary("就嘎疯狂进攻i罚款给你介绍考虑推荐上课时间航空技术的方式搭街坊四道口是搭街坊士大夫");
        animationBean7.setImageUrl("http://img2.imgtn.bdimg.com/it/u=2774662770," +
                "4241821896&fm=23&gp=0.jpg");
        guochanDatas.add(animationBean7);
        AnimationBean animationBean8 = new AnimationBean();
        animationBean8.setTitle("狐妖小红娘");
        animationBean8.setProgress(10);
        animationBean8.setUpdataTime("每周四更新");
        animationBean8.setState("连载中");
        animationBean8.setEpisode(12);
        animationBean8.setSummary("就嘎疯狂进攻i罚款给你介绍考虑推荐上课时间航空技术的方式搭街坊四道口是搭街坊士大夫");
        animationBean8.setImageUrl("http://i5.hunantv.com/p1/20160524/1211225980.jpg");
        guochanDatas.add(animationBean8);
        AnimationBean animationBean9 = new AnimationBean();
        animationBean9.setTitle("从前有座灵剑山 第二季");
        animationBean9.setProgress(8);
        animationBean9.setUpdataTime("每周一更新");
        animationBean9.setState("连载中");
        animationBean9.setEpisode(12);
        animationBean9.setSummary("就嘎疯狂进攻i罚款给你介绍考虑推荐上课时间航空技术的方式搭街坊四道口是搭街坊士大夫");
        animationBean9.setImageUrl("http://img1.gtimg.com/comic/pics/hv1/176/205/2040/132703451" +
                ".png");
        guochanDatas.add(animationBean9);
        updateData(guochanLayouts, guochanCards, guochanNames, guochanProgress, guochanImages,
                guochanDatas);

        AnimationBean animationBean10 = new AnimationBean();
        animationBean10.setTitle("夏目友人帐");
        animationBean10.setProgress(11);
        animationBean10.setUpdataTime("11话全");
        animationBean10.setState("已完结");
        animationBean10.setEpisode(11);
        animationBean10.setSummary("从小便能看见妖怪的少年夏目贵志。自从他从祖母玲子那里继承了与妖怪成为主从并将其名字书写在上的契约书“友人帐”以来，便于自称为保镖的妖怪猫咪老师一同，开始了将名字返还给妖怪的每一天。夏目与各种各样的妖怪与善良人们相遇，在构筑问年的场所同时，也反复寄托着想要守护重要之物的想法。");
        animationBean10.setImageUrl("http://img0.imgtn.bdimg.com/it/u=3686908230," +
                "3056259712&fm=21&gp=0.jpg");
        fenjiDatas.add(animationBean10);
        AnimationBean animationBean11 = new AnimationBean();
        animationBean11.setTitle("Fate/Grand Order-First Order");
        animationBean11.setProgress(1);
        animationBean11.setUpdataTime("1话全");
        animationBean11.setState("已完结");
        animationBean11.setEpisode(1);
        animationBean11.setSummary("就嘎疯狂进攻i罚款给你介绍考虑推荐上课时间航空技术的方式搭街坊四道口是搭街坊士大夫");
        animationBean11.setImageUrl("http://img2.imgtn.bdimg.com/it/u=1010485983," +
                "3883995921&fm=23&gp=0.jpg");
        fenjiDatas.add(animationBean11);
        AnimationBean animationBean12 = new AnimationBean();
        animationBean12.setTitle("我太受欢迎了怎么办");
        animationBean12.setProgress(12);
        animationBean12.setUpdataTime("12话全");
        animationBean12.setState("已完结");
        animationBean12.setEpisode(12);
        animationBean12.setSummary("就嘎疯狂进攻i罚款给你介绍考虑推荐上课时间航空技术的方式搭街坊四道口是搭街坊士大夫");
        animationBean12.setImageUrl("http://2t.5068.com/uploads/allimg/160613/1-1606131K114.jpg");
        fenjiDatas.add(animationBean12);
        updateData(fenjiLayouts, fenjiCards, fenjiNames, fenjiProgress, fenjiImages, fenjiDatas);

        AnimationBean animationBean13 = new AnimationBean();
        animationBean13.setTitle("面包带来和平！");
        animationBean13.setProgress(11);
        animationBean13.setUpdataTime("11话全");
        animationBean13.setState("已完结");
        animationBean13.setEpisode(11);
        animationBean13.setSummary("要记住！法棍是粮食同时也是武器哦！");
        animationBean13.setImageUrl("https://ss0.bdstatic" +
                ".com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2995206238,1927495932&fm=23&gp=0.jpg");
        animationBean13.setBigImageUrl("https://timgsa.baidu" +
                ".com/timg?image&quality=80&size=b9999_10000&sec=1488875698&di" +
                "=c27d16b7a2e0cd9757f1b08107767f4e&imgtype=jpg&er=1&src=http%3A%2F%2Fatt.bbs" +
                ".duowan.com%2Fforum%2F201603%2F29%2F224442zttx8mfb2lestedt.png");
        tuijianDatas.add(animationBean13);
        AnimationBean animationBean14 = new AnimationBean();
        animationBean14.setTitle("阿茹茉妮");
        animationBean14.setProgress(1);
        animationBean14.setUpdataTime("1话全");
        animationBean14.setState("已完结");
        animationBean14.setEpisode(1);
        animationBean14.setSummary("梦境就是现实，现实是梦境？\n每个人都能有自己的理解");
        animationBean14.setImageUrl("https://timgsa.baidu" +
                ".com/timg?image&quality=80&size=b9999_10000&sec=1488281187954&di" +
                "=0eed3c1a2f5211153ee25f92c5744851&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu" +
                ".com%2Fforum%2Fw%253D580%2Fsign%3D9c9f1b9c369b033b2c88fcd225cf3620" +
                "%2F7cd98d1001e93901698a8ba679ec54e737d19699.jpg");
        animationBean14.setBigImageUrl("https://timgsa.baidu" +
                ".com/timg?image&quality=80&size=b9999_10000&sec=1488281157412&di" +
                "=59b17430ed210a7fafb89e41ef288dbe&imgtype=0&src=http%3A%2F%2Fi1.hdslb" +
                ".com%2Fu_user%2F048d5efb0ba4378d090152f5430d410e.jpg");
        tuijianDatas.add(animationBean14);
        AnimationBean animationBean15 = new AnimationBean();
        animationBean15.setTitle("台风的诺尔达");
        animationBean15.setProgress(12);
        animationBean15.setUpdataTime("每周六更新");
        animationBean15.setState("连载中");
        animationBean15.setEpisode(12);
        animationBean15.setSummary("少女乘着台风而来");
        animationBean15.setImageUrl("https://timgsa.baidu" +
                ".com/timg?image&quality=80&size=b9999_10000&sec=1488281505633&di" +
                "=cf28863a0b2a8a78db56fc105b2e1c39&imgtype=0&src=http%3A%2F%2Fi.gtimg" +
                ".cn%2Fqqlive%2Fimg%2Fjpgcache%2Ffiles%2Fqqvideo%2Fl%2Fltcwfv0pz5ygxtv.jpg");
        animationBean15.setBigImageUrl("https://timgsa.baidu" +
                ".com/timg?image&quality=80&size=b9999_10000&sec=1488281420448&di" +
                "=ab6a86f31c3e118cd2da7f2203471b5a&imgtype=0&src=http%3A%2F%2Fqn.18touch" +
                ".com%2Fuploads%2Facg201501%2F1430541961238249.jpg");
        tuijianDatas.add(animationBean15);
        AnimationBean animationBean16 = new AnimationBean();
        animationBean16.setTitle("野良神");
        animationBean16.setProgress(24);
        animationBean16.setUpdataTime("24话全");
        animationBean16.setState("已完结");
        animationBean16.setEpisode(24);
        animationBean16.setSummary("字幕组三大杀手齐聚\n某两人隔空放闪光弹，感觉台上都是自己人");
        animationBean16.setImageUrl("https://timgsa.baidu" +
                ".com/timg?image&quality=80&size=b9999_10000&sec=1488281853795&di" +
                "=aed9a403787ede6ea2d325d591df9257&imgtype=0&src=http%3A%2F%2Fimg5.duitang" +
                ".com%2Fuploads%2Fitem%2F201503%2F11%2F20150311210235_h2Lvn.thumb.700_0.jpeg");
        animationBean16.setBigImageUrl("https://timgsa.baidu" +
                ".com/timg?image&quality=80&size=b9999_10000&sec=1488281815487&di" +
                "=667c58cbf01917cd66626a0c628c0d8d&imgtype=0&src=http%3A%2F%2Feasyread.ph.126" +
                ".net%2FyynjK3o2UFcjbf6BE1OilA%3D%3D%2F7916702522803010389.jpg");
        tuijianDatas.add(animationBean16);
        AnimationBean animationBean17 = new AnimationBean();
        animationBean17.setTitle("青年黑杰克");
        animationBean17.setProgress(12);
        animationBean17.setUpdataTime("12话全");
        animationBean17.setState("已完结");
        animationBean17.setEpisode(12);
        animationBean17.setSummary("黑杰克医学生时代的过去\n那个曾经叫做间黑男的人\n也向往过光明");
        animationBean17.setImageUrl("https://timgsa.baidu" +
                ".com/timg?image&quality=80&size=b9999_10000&sec=1488282678093&di" +
                "=55f162ff8b529cbfce56204051cb0e17&imgtype=0&src=http%3A%2F%2Fwww.magicomic" +
                ".com%2Fshop%2Fimages%2F201504%2Fgoods_img%2F7094_G_1430290399351.jpg");
        animationBean17.setBigImageUrl("https://ss3.bdstatic" +
                ".com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2968466152,1715208633&fm=23&gp=0.jpg");
        tuijianDatas.add(animationBean17);
        updateTuijian(tuijianLayouts,  tuijianNames,tuijianSummary, tuijianImages, tuijianDatas);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialViewPagerHelper.registerScrollView(getActivity(), mScrollView, null);
    }

    void updateData(List<ViewGroup> layoutList, final List<CardView> cardList,
                    List<TextView> nameList, List<TextView> progressList, final List<ImageView>
                            imageList, final List<AnimationBean> dataList) {
        for (int i = 0; i < dataList.size(); i++) {
            AnimationBean animationBean = dataList.get(i);
            Glide.with(this).load(animationBean.getImageUrl()).into(imageList.get(i));
            nameList.get(i).setText(animationBean.getTitle());
            progressList.get(i).setText("更新至第"+animationBean.getProgress()+"话");
            final int finalI = i;
            layoutList.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), AnimationDetailActivity.class);
                    String imageUrl = dataList.get(finalI).getImageUrl();
                    int imageWidth = imageList.get(finalI).getWidth();
                    int imageHeight = imageList.get(finalI).getHeight();
                    intent.putExtra("imageUrl", imageUrl);
                    intent.putExtra("imageWidth", imageWidth);
                    intent.putExtra("imageHeight", imageHeight);
                    intent.putExtra("title",dataList.get(finalI).getTitle());
                    intent.putExtra("updateTime",dataList.get(finalI).getUpdataTime());
                    intent.putExtra("state",dataList.get(finalI).getState());
                    intent.putExtra("episode",dataList.get(finalI).getEpisode());
                    intent.putExtra("progress",dataList.get(finalI).getProgress());
                    intent.putExtra("summary",dataList.get(finalI).getSummary());
                    ActivityOptions transitionActivityOptions = ActivityOptions
                            .makeSceneTransitionAnimation(getActivity(), Pair.create((View)
                                    (imageList.get(finalI)), "share_image"), Pair.create((View)
                                    (cardList.get(finalI)), "share_card"));
                    startActivity(intent, transitionActivityOptions.toBundle());
                }
            });
        }
    }

    void updateTuijian(final List<ViewGroup> layoutList, List<TextView> nameList, List<TextView> summaryList, final List<ImageView>
            imageList, final List<AnimationBean> dataList) {
        for (int i = 0; i < dataList.size(); i++) {
            AnimationBean animationBean = dataList.get(i);
            Glide.with(this).load(animationBean.getBigImageUrl()).into(imageList.get(i));
            nameList.get(i).setText(animationBean.getTitle());
            summaryList.get(i).setText(animationBean.getSummary());
            final int finalI = i;
            layoutList.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), AnimationDetailActivity.class);
                    String imageUrl = dataList.get(finalI).getImageUrl();
                    int imageWidth = xinfanImages.get(0).getWidth();
                    int imageHeight = xinfanImages.get(0).getHeight();
                    intent.putExtra("imageUrl", imageUrl);
                    intent.putExtra("imageWidth", imageWidth);
                    intent.putExtra("imageHeight", imageHeight);
                    intent.putExtra("title",dataList.get(finalI).getTitle());
                    intent.putExtra("updateTime",dataList.get(finalI).getUpdataTime());
                    intent.putExtra("state",dataList.get(finalI).getState());
                    intent.putExtra("episode",dataList.get(finalI).getEpisode());
                    intent.putExtra("progress",dataList.get(finalI).getProgress());
                    intent.putExtra("summary",dataList.get(finalI).getSummary());
                    startActivity(intent,
                            ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
                }
            });
        }
    }
}
