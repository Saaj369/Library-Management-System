package com.example.librarymanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    protected static Library lib = new Library();
    public static final String tagMSG = "com.saaj.LibraryManagement.tag";

    public void add_Book_activity(View view){
        Intent intent = new Intent(this,AddActivity.class);
        startActivity(intent);
    }
    public void search_Title_activity(View view){
        Intent intent = new Intent(this,SearchActivity.class);
        startActivity(intent);
    }
    public void borrow_Book_activity(View view){
        Intent intent = new Intent(this, DisplayAllBooks.class);
        intent.putExtra(tagMSG,0);
        startActivity(intent);
    }
    public void return_Book_activity(View view){
        Intent intent = new Intent(this, DisplayAllBooks.class);
        intent.putExtra(tagMSG,1);
        startActivity(intent);
    }
    public void display_All_Books_activity(View view){
        Intent intent = new Intent(this, DisplayAllBooks.class);
        intent.putExtra(tagMSG,2);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lib.addBunchOfBooks();
    }
}