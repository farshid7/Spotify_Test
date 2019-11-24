package com.mydigipay.www.api.entity;

import java.util.List;

public class Track {
    private List<TrackItem> items;

    public List<TrackItem> getItems() {
        return items;
    }

    public void setItems(List<TrackItem> items) {
        this.items = items;
    }
}
