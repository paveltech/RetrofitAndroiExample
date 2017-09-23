package com.example.android.retrofitandroiexample.com.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by android on 9/23/2017.
 */

public class SongsItem {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("song_name")
    @Expose
    private String songName;
    @SerializedName("song_link")
    @Expose
    private String songLink;
    @SerializedName("album_name")
    @Expose
    private String albumName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLink) {
        this.songLink = songLink;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

}
