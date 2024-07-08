package com.example.libraryapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckBookActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_book);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Initialize here
        backButton = findViewById(R.id.back);

        backButton.setOnClickListener(view -> finish());

        fetchAvailableBooks();
    }

    private void fetchAvailableBooks() {
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);

        apiService.getAvailableBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()) {
                    List<Book> books = response.body();
                    BookAdapter adapter = new BookAdapter(CheckBookActivity.this, books);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(CheckBookActivity.this, "Failed to fetch books", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.e("CheckBookActivity", "Error: " + t.getMessage(), t);
                Toast.makeText(CheckBookActivity.this, "An error occurred: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
