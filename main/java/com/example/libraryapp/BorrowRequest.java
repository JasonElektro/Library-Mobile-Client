package com.example.libraryapp;

public class BorrowRequest {
    private String nrp_peminjam;
    private int book_id;

    // Constructor, getters and setters

    public BorrowRequest(String nrp_peminjam, int book_id) {
        this.nrp_peminjam = nrp_peminjam;
        this.book_id = book_id;
    }

    public String getNrp_peminjam() {
        return nrp_peminjam;
    }

    public void setNrp_peminjam(String nrp_peminjam) {
        this.nrp_peminjam = nrp_peminjam;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
}
