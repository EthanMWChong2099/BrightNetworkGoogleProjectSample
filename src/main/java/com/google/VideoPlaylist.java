package com.google;

import java.util.ArrayList;
import java.util.List;

/** A class used to represent a Playlist */
class VideoPlaylist {

    private String name;
    private List<Video> videos;

    public VideoPlaylist(String name){
        this.name = name;
        this.videos = new ArrayList<>();
    }

    public String getListName() {
        return this.name;
    }

    public void addVideo(Video video) {
        this.videos.add(video);
    }

    List<Video> getVideos() {
        return new ArrayList<>(this.videos);
    }
}
