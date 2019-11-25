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

public class ArtistViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private ImageView image;
    private final Context context;

    public ArtistViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.context = context;
        name=itemView.findViewById(R.id.name);
        image=itemView.findViewById(R.id.image);
    }
    public void initView(SearchItem searchItem){
        name.setText(searchItem.getName());
        Glide.with(context).load(searchItem.getImage()).placeholder(R.drawable.ic_place_holder).into(image);

    }
}
