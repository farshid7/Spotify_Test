package com.mydigipay.www.api.entity;

import java.util.List;

public class Artist {
    private List<ArtistItem> items;


    public List<ArtistItem> getItems() {
        return items;
    }

    public void setItems(List<ArtistItem> items) {
        this.items = items;
    }
}
