package com.example.hyunyoungpark.action;

import java.io.Serializable;
import java.util.List;


public class Movie implements Serializable {

    private final String title;
    private final String genre;
    private final String year;
    private boolean isSelected = false;


    public Movie(String title, String genre, String year) {

        this.title = title;
        this.genre = genre;
        this.year = year;
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
