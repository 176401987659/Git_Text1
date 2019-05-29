package com.example.git_text.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.git_text.MainActivity;
import com.example.git_text.R;
import com.example.git_text.bean.MeiNvBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemLongClick;

public class RlvMeiNvAdapter extends RecyclerView.Adapter {
    private  MainActivity mContext;
    private  ArrayList<MeiNvBean.ResultsBean> mList;

    public RlvMeiNvAdapter(MainActivity mainActivity, ArrayList<MeiNvBean.ResultsBean> list) {

        mContext = mainActivity;
        mList = list;
    }

    public void setList(ArrayList<MeiNvBean.ResultsBean> list) {
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_item, null);
        return new MeiNvViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        MeiNvViewHolder holder = (MeiNvViewHolder) viewHolder;

        final MeiNvBean.ResultsBean resultsBean = mList.get(i);

        Glide.with(mContext).load(resultsBean.getUrl()).into(holder.mImg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemLongClick!=null){
                    mOnItemLongClick.OnItemLongClick(i,resultsBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MeiNvViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.img)
        ImageView mImg;

        public MeiNvViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }

    public OnItemLongClick mOnItemLongClick;

    public void setOnItemLongClick(OnItemLongClick onItemLongClick) {
        mOnItemLongClick = onItemLongClick;
    }

    public interface OnItemLongClick{
        void OnItemLongClick(int position,MeiNvBean.ResultsBean resultsBean);
    }
}
