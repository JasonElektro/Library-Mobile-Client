// MenuActivity.java
package com.example.libraryapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private Button borrowReturnButton, checkBookButton, checkBorrowerButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        borrowReturnButton = findViewById(R.id.borrow_return);
        checkBookButton = findViewById(R.id.check_book);
        checkBorrowerButton = findViewById(R.id.check_borrower);
        logoutButton = findViewById(R.id.logout);

        borrowReturnButton.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, BorrowReturnActivity.class);
            startActivity(intent);
        });

        checkBookButton.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, CheckBookActivity.class);
            startActivity(intent);
        });

        checkBorrowerButton.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, CheckBorrowerActivity.class);
            startActivity(intent);
        });

        logoutButton.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
