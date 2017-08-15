package com.example.hyunyoungpark.bookdatabsedemo;

public class Book {
    private int id;
    private String title, author;

    public Book(String title, String author)
    {
        this.title = title;
        this.author = author;
    }

    //getter & setter Methods

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public String toString()
    {
        return  "BOOK [ id = " + id +" ,title = "+
                title + " ,Author  = "+author + " ]";
    }
}
