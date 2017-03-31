package com.taozi.twodimension.modules.novel.activity;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.taozi.twodimension.R;
import com.taozi.twodimension.activity.BaseActivity;
import com.taozi.twodimension.modules.novel.adatper.ChapterRecyclerViewAdapter;

import butterknife.BindView;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by Tao Yimin on 2017/3/7.
 */
public class NovelDetailActivity extends BaseActivity {
    @BindView(R.id.novel_appbar)
    AppBarLayout appBarLayout;
    @BindView(R.id.novel_collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.novel_toolbar)
    Toolbar toolbar;
    @BindView(R.id.novel_card)
    CardView cardView;
    @BindView(R.id.novel_image)
    ImageView imageView;
    @BindView(R.id.novel_background_image)
    ImageView backGroundImageView;
    @BindView(R.id.novel_back)
    ImageView backImageView;
    @BindView(R.id.novel_info)
    TextView novelInfo;
    @BindView(R.id.chapter_progress)
    TextView chapterProgress;
    @BindView(R.id.novel_summary)
    TextView novelSummary;
    @BindView(R.id.chapter_recyclerView)
    RecyclerView chapterRecyclerView;
    ChapterRecyclerViewAdapter adapter;

    @Override
    protected int setContentViewId() {
        return R.layout.activity_novel_detail;
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
        String imageUrl = getIntent().getStringExtra("imageUrl");
        Glide.with(this).load(imageUrl).into(imageView);
        Glide.with(this).load(imageUrl).bitmapTransform(new BlurTransformation(this, 25), new
                CenterCrop(this)).into(backGroundImageView);
        chapterProgress.setText("更新至"+getIntent().getStringExtra("progress"));
        novelSummary.setText(getIntent().getStringExtra("summary"));
        collapsingToolbarLayout.setTitle(getIntent().getStringExtra("name"));
        String[] strs = new String[8];
        strs[0] = "作者  ";
        strs[1] = getIntent().getStringExtra("author");
        strs[2] = "    更新  ";
        strs[3] = getIntent().getStringExtra("progress");
        strs[4] = "\n文库  ";
        strs[5] = getIntent().getStringExtra("source");
        strs[6] = "    状态  ";
        strs[7] = getIntent().getStringExtra("statue");
        int[] colors = new int[]{R.color.newsSummaryText, R.color.colorNovel, R.color
                .newsSummaryText, R.color.colorNovel, R.color.newsSummaryText, R.color
                .colorNovel, R.color.newsSummaryText, R.color.colorNovel};
        SpannableStringBuilder style = setTextDifferent(this, strs, colors);
        novelInfo.setText(style);
        adapter=new ChapterRecyclerViewAdapter(this,getIntent().getIntExtra("chapter",0));
        adapter.setOnItemClickListener(new ChapterRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ChapterRecyclerViewAdapter.GridViewHolder holder, int position) {
                Toast.makeText(NovelDetailActivity.this,position+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(ChapterRecyclerViewAdapter.GridViewHolder holder, int position) {

            }
        });
        chapterRecyclerView.setAdapter(adapter);
        chapterRecyclerView.setLayoutManager(new GridLayoutManager(this,5));
    }

    @Override
    protected void loadData() {

    }

    public static SpannableStringBuilder setTextDifferent(Context context,
                                                          String[] strs, int[] colors) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : strs) {
            if (str != null) {
                stringBuffer.append(str);
            }
        }
        SpannableStringBuilder style = new SpannableStringBuilder(new String(
                stringBuffer));
        int len = strs.length;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < len; i++) {
            endIndex += strs[i].length();
            style.setSpan(new ForegroundColorSpan(context.getResources()
                            .getColor(colors[i])), startIndex, endIndex,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            startIndex = endIndex;

        }
        return style;
    }
}
