package com.example.libraryapp;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("username")
    private String username;

    @SerializedName("access_level")
    private int accessLevel;

    public UserResponse(int id, String username, int accessLevel) {
        this.id = id;
        this.username = username;
        this.accessLevel = accessLevel;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getAccessLevel() {
        return accessLevel;
    }
}
