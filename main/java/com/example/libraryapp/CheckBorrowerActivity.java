// CheckBorrowerActivity.java
package com.example.libraryapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.libraryapp.BorrowRecordAdapter;
import com.example.libraryapp.ApiService;
import com.example.libraryapp.RetrofitClient;
import com.example.libraryapp.BorrowRecord;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckBorrowerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_borrower);

        recyclerView = findViewById(R.id.recycler_view);
        backButton = findViewById(R.id.back);

        backButton.setOnClickListener(view -> finish());

        fetchBorrowRecords();
    }

    private void fetchBorrowRecords() {
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);

        apiService.getBorrowRecords().enqueue(new Callback<List<BorrowRecord>>() {
            @Override
            public void onResponse(Call<List<BorrowRecord>> call, Response<List<BorrowRecord>> response) {
                if (response.isSuccessful()) {
                    List<BorrowRecord> records = response.body();
                    BorrowRecordAdapter adapter = new BorrowRecordAdapter(CheckBorrowerActivity.this, records);
                    recyclerView.setLayoutManager(new LinearLayoutManager(CheckBorrowerActivity.this));
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(CheckBorrowerActivity.this, "Failed to fetch records", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<BorrowRecord>> call, Throwable t) {
                Toast.makeText(CheckBorrowerActivity.this, "An error occurred", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
