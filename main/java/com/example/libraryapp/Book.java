package com.example.libraryapp;

import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("author")
    private String author;

    @SerializedName("available")
    private int available;

    @SerializedName("created_at")
    private String created_at;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCreated_at() {
        return created_at;
    }

    public int getAvailable() {
        return available;
    }
}
