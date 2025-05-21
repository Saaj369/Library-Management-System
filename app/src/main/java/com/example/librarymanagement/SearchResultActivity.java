package com.example.librarymanagement;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SearchResultActivity extends AppCompatActivity {
    public int bookIndex;

    public void borrowFoundBook(View view) {
        MainActivity.lib.borrowAbook(bookIndex);
        Button borrowbtn = findViewById(R.id.searchAcitivityBorrowButton);
        Button returnbtn = findViewById(R.id.searchAcitivityReturnButton);
        returnbtn.setVisibility(Button.VISIBLE);
        borrowbtn.setVisibility(Button.GONE);
        Toast.makeText(this, "Borrowed book successfully...", Toast.LENGTH_SHORT).show();
    }

    public void returnFoundBook(View view) {
        MainActivity.lib.returnAbook(bookIndex);
        Button borrowbtn = findViewById(R.id.searchAcitivityBorrowButton);
        Button returnbtn = findViewById(R.id.searchAcitivityReturnButton);
        returnbtn.setVisibility(Button.GONE);
        borrowbtn.setVisibility(Button.VISIBLE);
        Toast.makeText(this, "Retuned book successfully...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        bookIndex = intent.getIntExtra(SearchActivity.searchMSGbook,-1);

        TextView status = findViewById(R.id.bookFoundStatus);
        TextView foundTitle = findViewById(R.id.bookFoundTitle);
        TextView foundAuthor = findViewById(R.id.bookfoundAuthor);
        Button borrowbtn = findViewById(R.id.searchAcitivityBorrowButton);
        Button returnbtn = findViewById(R.id.searchAcitivityReturnButton);

        if (bookIndex != -1) {
            status.setText("Book Found:");
            status.setTextColor(Color.GREEN);
            Book foundBook = MainActivity.lib.getBookbyIndex(bookIndex);
            if (foundBook != null) {
                foundTitle.setText("Title: " + foundBook.getTitle());
                foundAuthor.setText("Author: " + foundBook.getAuthor());
                if (foundBook.isBorrowed()) {
                    returnbtn.setVisibility(Button.VISIBLE);
                    borrowbtn.setVisibility(Button.GONE);
                } else {
                    returnbtn.setVisibility(Button.GONE);
                    borrowbtn.setVisibility(Button.VISIBLE);
                }
            }
        } else {
            status.setText("Book Not Found...");
            status.setTextColor(Color.RED);
            returnbtn.setVisibility(Button.GONE);
            borrowbtn.setVisibility(Button.GONE);
            foundTitle.setVisibility(TextView.GONE);
            foundAuthor.setVisibility(TextView.GONE);
        }
    }
}
