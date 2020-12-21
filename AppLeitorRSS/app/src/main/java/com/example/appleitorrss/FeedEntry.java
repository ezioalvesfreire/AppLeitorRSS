package com.example.appleitorrss;

import java.io.Serializable;

public class FeedEntry implements Serializable{

    private String name;
    private String artist;
    private String releaseData;
    private String summary;
    private String imgURL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseData() {
        return releaseData;
    }

    public void setReleaseData(String releaseData) {
        this.releaseData = releaseData;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @Override
    public String toString() {
        return  "name=" + name + '\n' +
                "artist=" + artist + '\n' +
                "releaseData=" + releaseData + '\n' +
                "imgURL=" + imgURL + '\n'  ;
    }
}