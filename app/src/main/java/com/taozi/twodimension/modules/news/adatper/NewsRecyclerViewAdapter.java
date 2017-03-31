package com.taozi.twodimension.modules.news.adatper;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.taozi.twodimension.R;
import com.taozi.twodimension.modules.news.bean.NewsBean;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by Tao Yimin on 2016/12/17.
 */
public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter
        .BaseViewHolder> {
    Context context;
    List<NewsBean> dataList;
    OnItemClickListener onItemClickListener;
    private int lastPosition=0;

    public NewsRecyclerViewAdapter(Context context, List<NewsBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        BaseViewHolder viewHolder = null;
        switch (viewType) {
            case 0:
                //实例化一个一张图片的ViewHolder
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout
                        .layout_news_one_image, parent, false);
                viewHolder = new OneImageViewHolder(itemView);
                break;
            case 1:
                //实例化一个三张图片的ViewHolder(图片大小相同)
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout
                        .layout_news_three_image, parent, false);
                viewHolder = new ThreeImageViewHolder(itemView);
                break;
/*            case 2:
                //实例化一个三张图片的ViewHolder(图片大小不同)
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout
                        .layout_news_three_image2, parent, false);
                viewHolder = new ThreeImageViewHolder(itemView);
                break;*/
            default:
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BaseViewHolder holder, int position) {
        NewsBean newsBean = dataList.get(position);
        switch (newsBean.getType()) {
            case 0:
                fillDataOneImage(holder, newsBean);
                break;
            case 1:
            /*case 2:*/
                fillDataThreeImage(holder, newsBean);
                break;
            default:
                break;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(holder, holder.getLayoutPosition());
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemLongClick(holder, holder.getLayoutPosition());
                }
                return true;
            }
        });
        setAnimation(holder.newsCardView,position);
    }


    /**
     * 将数据填充到一张图片的布局
     * @param holder
     * @param newsBean
     */
    private void fillDataOneImage(BaseViewHolder holder, NewsBean newsBean) {
        OneImageViewHolder viewHolder = (OneImageViewHolder) holder;
        holder.titleTextView.setText(newsBean.getTitle()+"");
        holder.summaryTextView.setText(newsBean.getSummary()+"");
        holder.timeTextView.setText(newsBean.getSource()+"");
        holder.browseTextView.setText(newsBean.getBrowse()+"");
        holder.commentTextView.setText(newsBean.getComment()+"");
        Glide.with(context).load(newsBean.getImages()[0]).into(((OneImageViewHolder) holder)
                .imageView);
    }

    /**
     * 将数据填充到三张图片的布局
     * @param holder
     * @param newsBean
     */
    private void fillDataThreeImage(BaseViewHolder holder, NewsBean newsBean) {
        ThreeImageViewHolder viewHolder = (ThreeImageViewHolder) holder;
        holder.titleTextView.setText(newsBean.getTitle()+"");
        holder.summaryTextView.setText(newsBean.getSummary()+"");
        holder.timeTextView.setText(newsBean.getSource()+"");
        holder.browseTextView.setText(newsBean.getBrowse()+"");
        holder.commentTextView.setText(newsBean.getComment()+"");
        String[] images = newsBean.getImages();
        for (int i = 0; i < images.length; i++) {
            Glide.with(context).load(images[i]).into(viewHolder.viewList.get(i));
        }
    }

    /**
     * item的入场动画
     * @param viewToAnimate
     * @param position
     */
    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            //手指上滑
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R.anim.item_bottom_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        } else {
            //手指下滑
            lastPosition--;
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /**
     * item滑出屏幕时清空动画
     *
     * @param holder
     */
    @Override
    public void onViewDetachedFromWindow(BaseViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    /**
     * 返回布局类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).getType();
    }

    /**
     * 所有ViewHolder的基类
     */
    public class BaseViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.news_title)
        TextView titleTextView;
        @BindView(R.id.news_summary)
        TextView summaryTextView;
        @BindView(R.id.news_time)
        TextView timeTextView;
        @BindView(R.id.news_browse)
        TextView browseTextView;
        @BindView(R.id.news_comment)
        TextView commentTextView;
        @BindView(R.id.card_view)
        public CardView newsCardView;

        public BaseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class OneImageViewHolder extends BaseViewHolder {
        @BindView(R.id.news_image)
        public ImageView imageView;

        public OneImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class ThreeImageViewHolder extends BaseViewHolder {
        @BindViews({R.id.news_image_left, R.id.news_image_middle, R.id.news_image_right})
        public List<ImageView> viewList;

        public ThreeImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * item的点击事件和长按事件回调接口
     */
    public interface OnItemClickListener {
        void onItemClick(BaseViewHolder holder, int position);

        void onItemLongClick(BaseViewHolder holder, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
