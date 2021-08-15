package com.example.myntra.NavBarAvtivity.Studio;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myntra.R;

public class StudioViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvPImage;
    private TextView mTvName;
    private TextView mTvTime;
    private ImageView mIvImage;
    private TextView mTvLike;
    private TextView mTvMessage;
    private RelativeLayout relativeLayout;

    public StudioViewHolder(@NonNull View itemView) {
        super(itemView);
        iniViews(itemView);
    }

    private void iniViews(View itemView) {
        mIvPImage = itemView.findViewById(R.id.ivPImage);
        mTvName = itemView.findViewById(R.id.tvName);
        mTvTime = itemView.findViewById(R.id.tvTime);
        mIvImage = itemView.findViewById(R.id.ivImage);
        mTvLike = itemView.findViewById(R.id.tvHeartLike);
        mTvMessage = itemView.findViewById(R.id.tvMessage);
        relativeLayout = itemView.findViewById(R.id.relativeLayout);
    }

    public void setData(StudioData studioData) {
        mIvPImage.setImageResource(studioData.getpImageView());
        mTvName.setText(studioData.getName());
        mTvTime.setText(studioData.getTime());
        mIvImage.setImageResource(studioData.getImageView());
        mTvLike.setText(studioData.getLike());
        mTvMessage.setText(studioData.getMessage());
    }
}