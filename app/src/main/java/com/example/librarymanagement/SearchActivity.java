package com.example.librarymanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SearchActivity extends AppCompatActivity {

    public static final String searchMSGbook = "com.saaj.LibraryManagement.searchMSG.book";
    public void search_Book(View view){
        EditText title = findViewById(R.id.searchtitleField);

        int bookIndex = MainActivity.lib.searchTitle(title.getText().toString());

        Intent intent = new Intent(this,SearchResultActivity.class);

        intent.putExtra(searchMSGbook,bookIndex);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}