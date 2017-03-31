package com.taozi.twodimension.modules.animation.activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.taozi.twodimension.R;
import com.taozi.twodimension.activity.BaseActivity;
import com.taozi.twodimension.modules.animation.adatper.EpisodeRecyclerViewAdapter;

import butterknife.BindView;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by Tao Yimin on 2017/2/27.
 */
public class AnimationDetailActivity extends BaseActivity{
    @BindView(R.id.animation_appbar)
    AppBarLayout appBarLayout;
    @BindView(R.id.animation_collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.animation_toolbar)
    Toolbar toolbar;
    @BindView(R.id.animation_card)
    CardView cardView;
    @BindView(R.id.animation_image)
    ImageView imageView;
    @BindView(R.id.animation_background_image)
    ImageView backGroundImageView;
    @BindView(R.id.animation_back)
    ImageView backImageView;
    @BindView(R.id.animation_state_update)
    TextView stateUpdateText;
    @BindView(R.id.episode_progress)
    TextView episodeProgress;
    @BindView(R.id.animation_summary)
    TextView animationSummary;
    @BindView(R.id.episode_recyclerView)
    RecyclerView episodeRecyclerView;
    EpisodeRecyclerViewAdapter adapter;

    @Override
    protected int setContentViewId() {
        return R.layout.activity_animation_detail;
    }

    @Override
    protected void findViews() {

    }

    @Override
    protected void initEvent() {
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void init() {
        //getWindow().setEnterTransition(new Slide(Gravity.LEFT));
        String imageUrl=getIntent().getStringExtra("imageUrl");
        int imageWidth=getIntent().getIntExtra("imageWidth",0);
        int imageHeight=getIntent().getIntExtra("imageHeight",0);
        ViewGroup.LayoutParams params=imageView.getLayoutParams();
        params.width=imageWidth;
        params.height=imageHeight;
        imageView.setLayoutParams(params);
        ViewGroup.LayoutParams params2=cardView.getLayoutParams();
        params2.width=imageWidth;
        params2.height=imageHeight;
        cardView.setLayoutParams(params2);
        Glide.with(this).load(imageUrl).into(imageView);
        Glide.with(this).load(imageUrl).bitmapTransform(new BlurTransformation(this, 25), new CenterCrop(this)).into(backGroundImageView);
        collapsingToolbarLayout.setTitle(getIntent().getStringExtra("title"));
        String state=getIntent().getStringExtra("state");
        if("连载中".equals(state)){
            episodeProgress.setText("更新至第"+getIntent().getIntExtra("progress",0)+"话>");
        }else{
            episodeProgress.setText(getIntent().getIntExtra("episode",0)+"话全>");
        }
        stateUpdateText.setText(getIntent().getStringExtra("state")+","+getIntent().getStringExtra("updateTime"));
        animationSummary.setText(getIntent().getStringExtra("summary"));
        adapter=new EpisodeRecyclerViewAdapter(this,getIntent().getIntExtra("progress",0));
        adapter.setOnItemClickListener(new EpisodeRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(EpisodeRecyclerViewAdapter.GridViewHolder holder, int position) {
                Toast.makeText(AnimationDetailActivity.this,position+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(EpisodeRecyclerViewAdapter.GridViewHolder holder, int position) {

            }
        });
        episodeRecyclerView.setAdapter(adapter);
        episodeRecyclerView.setLayoutManager(new GridLayoutManager(this,5));
    }

    @Override
    protected void loadData() {

    }
}
