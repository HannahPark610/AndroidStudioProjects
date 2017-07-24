package com.example.hyunyoungpark.action;

import java.io.Serializable;


public class Movie implements Serializable {

    private String title;
    private String genre;
    private String year;
    private int thumbnail;
    private boolean isSelected;

    public Movie(String title, String genre, String year, int thumbnail) {

        this.title = title;
        this.genre = genre;
        this.year = year;
        this.thumbnail = thumbnail;
        this.isSelected = false;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getTitle() {

        return title;
    }

    public String getGenre() {

        return genre;
    }

    public String getYear() {

        return year;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {

        isSelected = selected;
    }
}
