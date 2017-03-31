package com.taozi.twodimension.modules.news.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.taozi.twodimension.R;
import com.taozi.twodimension.fragment.BaseFragment;
import com.taozi.twodimension.modules.news.activity.NewsDetailActivity;
import com.taozi.twodimension.modules.news.adatper.NewsRecyclerViewAdapter;
import com.taozi.twodimension.modules.news.bean.NewsBean;
import com.taozi.twodimension.modules.news.i.NewsServers;
import com.taozi.twodimension.util.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Tao Yimin on 2016/12/17.
 */
public class NewsFragment extends BaseFragment {
    NewsRecyclerViewAdapter mAdapter;
    List<NewsBean> mDataList;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_recyclerview;
    }

    @Override
    protected void findViews(View view) {
    }

    @Override
    protected void initEvent() {
        mDataList = new ArrayList<>();
        mAdapter = new NewsRecyclerViewAdapter(getActivity(), mDataList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //item的size固定可以设置为true提高性能,但是我的item高度由内容决定,所以设置为false
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        mAdapter.setOnItemClickListener(new NewsRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(NewsRecyclerViewAdapter.BaseViewHolder holder, int position) {
                String[] images = mDataList.get(position).getImages();
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                intent.putExtra("images", images);
                intent.putExtra("title",mDataList.get(position).getTitle());
                intent.putExtra("contentUrl",mDataList.get(position).getContentUrl());
                ActivityOptions transitionActivityOptions = null;
                if (holder instanceof NewsRecyclerViewAdapter.OneImageViewHolder) {
                    NewsRecyclerViewAdapter.OneImageViewHolder viewHolder =
                            (NewsRecyclerViewAdapter.OneImageViewHolder) holder;
                    intent.putExtra("imageWidth", viewHolder.imageView.getWidth());
                    intent.putExtra("imageHeight", viewHolder.imageView.getHeight());
                    transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation
                            (getActivity(), Pair.create((View) (viewHolder.imageView),
                                    "share_image1"));
                } else if (holder instanceof NewsRecyclerViewAdapter.ThreeImageViewHolder) {
                    NewsRecyclerViewAdapter.ThreeImageViewHolder viewHolder =
                            (NewsRecyclerViewAdapter.ThreeImageViewHolder) holder;
                    intent.putExtra("imageWidth", viewHolder.viewList.get(0).getWidth());
                    intent.putExtra("imageHeight", viewHolder.viewList.get(0).getHeight());
                    transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation
                            (getActivity(), Pair.create((View) (viewHolder.viewList.get(0)),
                                    "share_image1"), Pair.create((View) (viewHolder.viewList.get
                                    (1)), "share_image2"), Pair.create((View) (viewHolder
                                    .viewList.get(2)), "share_image3"));
                }
                startActivity(intent, transitionActivityOptions.toBundle());
            }

            @Override
            public void onItemLongClick(NewsRecyclerViewAdapter.BaseViewHolder holder, int
                    position) {

            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        NewsServers newsServers = retrofit.create(NewsServers.class);
        Observable<List<NewsBean>> observable=newsServers.getNews();
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<NewsBean>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(List<NewsBean> newsBeen) {
                        mDataList.addAll(newsBeen);
                        mAdapter.notifyDataSetChanged();
                    }
                });
    }
}
