package com.mydigipay.www.main.adapter.data;

import com.mydigipay.www.api.entity.ArtistItem;
import com.mydigipay.www.api.entity.SearchResult;
import com.mydigipay.www.api.entity.TrackItem;

import java.util.ArrayList;
import java.util.List;

public class SearchDataProvider {
    public static List<SearchItem> Provide(SearchResult searchResult) {
        List<SearchItem> searchItems = new ArrayList<>();
        for (TrackItem trackItems :
                searchResult.getTracks().getItems()) {
            SearchItem searchItem = new SearchItem();
            searchItem.setType(1);
            searchItem.setId(trackItems.getId());
            searchItem.setName(trackItems.getName());
            if (trackItems.getAlbum().getImages() != null) {
                if (trackItems.getAlbum().getImages().size() > 0) {
                    searchItem.setImage(trackItems.getAlbum().getImages().get(0).getUrl());
                }
            }
            String artistName = "";
            for (ArtistItem artistItem
                    : trackItems.getArtists()) {
                artistName = artistName + artistItem.getName() + " ";
            }
            searchItem.setArtistName(artistName);
            searchItems.add(searchItem);
        }
        for (ArtistItem artistItem :
                searchResult.getArtists().getItems()) {
            SearchItem searchItem = new SearchItem();
            searchItem.setType(2);
            searchItem.setName(artistItem.getName());
            searchItem.setId(artistItem.getId());
            if (artistItem.getImages() != null) {
                if (artistItem.getImages().size() > 0) {
                    searchItem.setImage(artistItem.getImages().get(0).getUrl());
                }
            }
            for (int i = 0; i < 50; i++) {
                searchItems.add(searchItem);

            }
        }

        return searchItems;
    }
}
