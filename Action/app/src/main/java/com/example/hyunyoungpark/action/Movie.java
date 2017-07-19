package com.example.hyunyoungpark.action;

import java.util.List;


public class Movie {

    private final String title;
    private final String genre;
    private final String year;




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


}
