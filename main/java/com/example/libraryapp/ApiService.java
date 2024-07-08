// ApiService.java
package com.example.libraryapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @POST("/login")
    Call<UserResponse> login(@Body User user);

    @POST("/signup")
    Call<Void> signup(@Body User user);

    @GET("/available_books")
    Call<List<Book>> getAvailableBooks();

    @GET("/borrow_records")
    Call<List<BorrowRecord>> getBorrowRecords();

    @POST("/borrow")
    Call<Void> borrowBook(@Body BorrowRequest request);

    @POST("/return")
    Call<Void> returnBook(@Body BorrowRequest request);
}
