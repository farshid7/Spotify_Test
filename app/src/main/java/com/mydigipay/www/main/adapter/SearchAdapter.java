package com.mydigipay.www.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mydigipay.www.R;
import com.mydigipay.www.api.entity.SearchResult;
import com.mydigipay.www.main.adapter.data.SearchDataProvider;
import com.mydigipay.www.main.adapter.data.SearchItem;
import com.mydigipay.www.main.adapter.viewHolders.ArtistViewHolder;
import com.mydigipay.www.main.adapter.viewHolders.TrackViewHolder;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<SearchItem> searchItemList;
    private final Context context;

    public static SearchAdapter Init(RecyclerView recyclerView){
        SearchAdapter searchAdapter=new SearchAdapter(recyclerView.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(searchAdapter);
        return searchAdapter;
    }

    private SearchAdapter(Context context) {
        this.context = context;
        this.searchItemList = new ArrayList<>();
    }
    public List<SearchItem> getSearchItemList(){
        return searchItemList;
    }

    public void addItem(List<SearchItem> searchItemList){
        this.searchItemList=searchItemList;
        this.notifyDataSetChanged();
    }

    public void addItem(SearchResult searchResult){
        this.searchItemList= SearchDataProvider.Provide(searchResult);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return searchItemList.get(position).getType();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1:
                return new TrackViewHolder(LayoutInflater.from(context).inflate(R.layout.item_track, parent, false));
            case 2:
                return new ArtistViewHolder(LayoutInflater.from(context).inflate(R.layout.item_artist, parent, false));
            default:
                throw new RuntimeException("view type not valid!");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case 1:
                ((TrackViewHolder) holder).initView(searchItemList.get(position));
                break;
            case 2:
                ((ArtistViewHolder) holder).initView(searchItemList.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return searchItemList.size();
    }
}
