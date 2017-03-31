package com.taozi.twodimension.modules.music.adatper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.taozi.twodimension.R;
import com.taozi.twodimension.modules.music.bean.SongBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.gujun.android.taggroup.TagGroup;

/**
 * Created by Tao Yimin on 2017/3/5.
 */
public class SonglistRecyclerViewAdapter extends RecyclerView.Adapter<SonglistRecyclerViewAdapter
        .BaseViewHolder> {
    Context context;
    List<SongBean> dataList;
    HeadInitListener headInitListener;

    public SonglistRecyclerViewAdapter(Context context, List<SongBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=null;
        BaseViewHolder holder=null;
        switch (viewType) {
            case 0:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout
                        .layout_song_header, parent, false);
                holder=new SongHeadViewHolder(itemView);
                break;
            default:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout
                        .layout_music_song, parent, false);
                holder=new SongListViewHolder(itemView);
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        switch (position){
            case 0:
                if(headInitListener!=null){
                    headInitListener.headInit((SongHeadViewHolder) holder);
                }
                break;
            default:
                ((SongListViewHolder)holder).songName.setText(dataList.get(position).getName());
                ((SongListViewHolder)holder).songSpecial.setText(dataList.get(position).getSpecial());
                Glide.with(context).load(dataList.get(position).getImageUrl()).into(((SongListViewHolder)holder).songImage);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder{

        public BaseViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class SongListViewHolder extends BaseViewHolder {
        @BindView(R.id.song_image)
        ImageView songImage;
        @BindView(R.id.song_play)
        ImageView songPlay;
        @BindView(R.id.song_name)
        TextView songName;
        @BindView(R.id.song_special)
        TextView songSpecial;

        public SongListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class SongHeadViewHolder extends BaseViewHolder{
        @BindView(R.id.tag_group)
        public TagGroup tagGroup;
        @BindView(R.id.songlist_head)
        public ImageView imageView;

        public SongHeadViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface HeadInitListener{
        void headInit(SongHeadViewHolder holder);
    }

    public void setHeadInitListener(HeadInitListener headInitListener) {
        this.headInitListener = headInitListener;
    }
}
