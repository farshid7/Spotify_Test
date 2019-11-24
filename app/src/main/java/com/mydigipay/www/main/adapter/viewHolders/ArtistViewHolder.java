package com.mydigipay.www.main.adapter.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mydigipay.www.R;
import com.mydigipay.www.main.adapter.data.SearchItem;

public class ArtistViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    public ArtistViewHolder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.name);
    }
    public void initView(SearchItem searchItem){
        name.setText(searchItem.getName());
    }
}
