package com.taozi.twodimension.modules.animation.adatper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taozi.twodimension.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tao Yimin on 2017/3/2.
 */
public class EpisodeRecyclerViewAdapter extends RecyclerView.Adapter<EpisodeRecyclerViewAdapter.GridViewHolder>{
    Context context;
    Integer episode;
    OnItemClickListener onItemClickListener;

    public EpisodeRecyclerViewAdapter(Context context, Integer episode) {
        this.context = context;
        this.episode = episode;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=LayoutInflater.from(context)
                .inflate(R.layout.layout_episode_item, parent, false);
        return new GridViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final GridViewHolder holder, int position) {
        holder.episodeNumber.setText(position+1+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener!=null){
                    onItemClickListener.onItemClick(holder,holder.getLayoutPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return episode;
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.episode_number)
        TextView episodeNumber;

        public GridViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * item的点击事件和长按事件回调接口
     */
    public interface OnItemClickListener {
        void onItemClick(GridViewHolder holder, int position);

        void onItemLongClick(GridViewHolder holder, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
