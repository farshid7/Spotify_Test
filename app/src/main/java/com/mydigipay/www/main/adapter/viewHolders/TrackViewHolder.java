package com.mydigipay.www.main.adapter.viewHolders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mydigipay.www.R;
import com.mydigipay.www.main.adapter.data.SearchItem;

public class TrackViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView artistName;
    private Context context;
    private ImageView image;

    public TrackViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        name = itemView.findViewById(R.id.name);
        artistName = itemView.findViewById(R.id.artistName);
        image = itemView.findViewById(R.id.image);
    }

    public void initView(SearchItem searchItem) {
        name.setText(searchItem.getName());
        artistName.setText(searchItem.getArtistName());
        Glide.with(context).load(searchItem.getImage()).placeholder(R.drawable.ic_place_holder).into(image);

    }
}
