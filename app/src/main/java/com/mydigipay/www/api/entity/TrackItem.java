package com.mydigipay.www.api.entity;

import java.util.List;

public class TrackItem {
    private String id;
    private String name;
    private List<ArtistItem> artists;
    private Album album;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArtistItem> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistItem> artists) {
        this.artists = artists;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
