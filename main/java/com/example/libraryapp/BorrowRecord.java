package com.example.libraryapp;

import com.google.gson.annotations.SerializedName;

public class BorrowRecord {

    @SerializedName("id")
    private int id;

    @SerializedName("nrp_peminjam")
    private String nrpPeminjam;

    @SerializedName("book_id")
    private int bookId;

    @SerializedName("borrowed_at")
    private String borrowedAt;

    @SerializedName("returned_at")
    private String returnedAt;

    public int getId() {
        return id;
    }

    public String getNrpPeminjam() {
        return nrpPeminjam;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBorrowedAt() {
        return borrowedAt;
    }

    public String getReturnedAt() {
        return returnedAt;
    }
}
