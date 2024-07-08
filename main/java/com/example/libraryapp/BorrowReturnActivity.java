// BorrowReturnActivity.java
package com.example.libraryapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BorrowReturnActivity extends AppCompatActivity {

    private EditText nrpEditText, bookIdEditText;
    private Button borrowButton, returnButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_return);

        nrpEditText = findViewById(R.id.nrp);
        bookIdEditText = findViewById(R.id.book_id);
        borrowButton = findViewById(R.id.borrow);
        returnButton = findViewById(R.id.kembali);
        backButton = findViewById(R.id.back);

        borrowButton.setOnClickListener(view -> borrowBook());
        returnButton.setOnClickListener(view -> returnBook());
        backButton.setOnClickListener(view -> finish());
    }

    private void borrowBook() {
        String nrp = nrpEditText.getText().toString();
        int bookId = Integer.parseInt(bookIdEditText.getText().toString());

        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
        BorrowRequest request = new BorrowRequest(nrp, bookId);

        apiService.borrowBook(request).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(BorrowReturnActivity.this, "Book borrowed", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BorrowReturnActivity.this, "Borrow failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(BorrowReturnActivity.this, "An error occurred", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void returnBook() {
        String nrp = nrpEditText.getText().toString();
        int bookId = Integer.parseInt(bookIdEditText.getText().toString());

        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
        BorrowRequest request = new BorrowRequest(nrp, bookId);

        apiService.returnBook(request).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(BorrowReturnActivity.this, "Book returned", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BorrowReturnActivity.this, "Return failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(BorrowReturnActivity.this, "An error occurred", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
