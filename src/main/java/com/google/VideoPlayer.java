package com.google;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  private List<Video> videos = new ArrayList<>();
  private Video currentVid;
  private List<String> playlist = new ArrayList<>();
  private boolean vidStopped = false;
  private boolean vidPaused = false;
  private boolean vidChosen = false;
  private String vidTitle;
  private VideoPlaylist videoPlaylist;
  private boolean listMade = false;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    videos = this.videoLibrary.getVideos();
    videos.sort(Comparator.comparing(Video::getTitle));
    System.out.println("Here's a list of all available videos:");
    for (Video vid : videos){

      System.out.println(vid.getTitle() + " (" + vid.getVideoId() + ") " + vid.getTags().toString().replace("," , ""));
    }
  }

  public void playVideo(String videoId) {
    if (this.vidChosen == true && this.vidStopped == false || this.vidChosen == true && this.vidPaused == true){
      stopVideo();
    }
    this.currentVid = this.videoLibrary.getVideo(videoId);
    videos = this.videoLibrary.getVideos();
    if (this.currentVid != null) {
      for (Video vid : videos){
        if (currentVid.getVideoId() == vid.getVideoId()) {
          System.out.println("Playing video: " + currentVid.getTitle());
          this.vidStopped = false;
          this.vidPaused = false;
          this.vidChosen = true;
          this.vidTitle = currentVid.getTitle();
        }
      }
    }
    if (this.currentVid == null || this.vidChosen == false){
      System.out.println("Cannot play video: Video does not exist");
    }
  }

  public void stopVideo() {
    if (this.currentVid == null || this.vidStopped == true && vidChosen == false){
      System.out.println("Cannot stop video: No video is currently playing");
    }
    else if (this.vidStopped == false || this.vidChosen == true){
      System.out.println("Stopping video: " + this.vidTitle);
      this.vidStopped = true;
      this.vidChosen = false;
    }
  }

  public void playRandomVideo() {
    int randomInt = (int) Math.random();
    videos = this.videoLibrary.getVideos();
    this.currentVid = videos.get(randomInt);
    for (Video vid : videos){
      if (this.currentVid.getVideoId() == vid.getVideoId()) {
        playVideo(this.currentVid.getVideoId());
      }
    }
  }

  public void pauseVideo() {
    if (this.vidPaused == false && this.vidChosen == true){
      System.out.println("Pausing video: " + this.currentVid.getTitle());
      this.vidPaused = true;
    }
    else if (this.vidChosen == false){
      System.out.println("Cannot pause video: No video is currently playing");
    }
    else {
      System.out.println("Video already paused: " + this.currentVid.getTitle());
    }
  }

  public void continueVideo() {
    if (this.vidPaused == true && this.vidChosen == true){
      System.out.println("Continuing video: " + this.currentVid.getTitle());
      this.vidPaused = false;
    }
    else if (this.vidPaused == false && this.vidChosen == true) {
      System.out.println("Cannot continue video: Video is not paused");
    }
    else {
      System.out.println("Cannot continue video: No video is currently playing");
    }
  }

  public void showPlaying() {
    if (this.vidChosen == false){
      System.out.println("No video is currently playing");
    }
    else if (this.vidPaused == true){
      System.out.println("Currently playing: " + this.currentVid.getTitle() + " (" + this.currentVid.getVideoId() + ") " + this.currentVid.getTags().toString().replace("," , "") + " - PAUSED");
    }
    else if (this.vidStopped == true){
      System.out.println("STOPPED");
    }
    else {
      System.out.println("Currently playing: " + this.currentVid.getTitle() + " (" + this.currentVid.getVideoId() + ") " + this.currentVid.getTags().toString().replace("," , ""));
    }
  }

  public void createPlaylist(String playlistName) {
    this.videoPlaylist = new VideoPlaylist(playlistName);
   for (String name: playlist) {
      if (name == videoPlaylist.getListName()) {
        listMade = true;
        System.out.println("Cannot create playlist: A playlist with the same name already exists");
      }
    }
    if (listMade == false){
      System.out.println("Successfully created new playlist: " + videoPlaylist.getListName());
    }
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("Added video to " + playlistName + ": " + videoId);
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {

    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}