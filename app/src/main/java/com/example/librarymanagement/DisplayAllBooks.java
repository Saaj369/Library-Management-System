package com.example.librarymanagement;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisplayAllBooks extends AppCompatActivity implements View.OnClickListener {
    private SparseArray<Book> bookMap = new SparseArray<>();
    private int tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display_all_books);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        tag = intent.getIntExtra(MainActivity.tagMSG,2);

        displayBooks(tag);
    }

    @Override
    protected void onResume(){
        super.onResume();
        displayBooks(tag);
    }

    @Override
    public void onClick(View view) {
        Book book = bookMap.get(view.getId());
        if (book != null) {
            Intent intent = new Intent(DisplayAllBooks.this, SearchResultActivity.class);
            intent.putExtra(SearchActivity.searchMSGbook, book.index);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Book not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void displayBooks(int tag) {
        LinearLayout linearLayout = findViewById(R.id.listBooks);
        TextView status = findViewById(R.id.displayAllBookStatus);
        linearLayout.removeAllViews();
        if(tag == 2){
            status.setText("All Books");
            for (Book book : MainActivity.lib.books) {
                Button btn = new Button(this);
                btn.setText(book.getTitle());
                int id = View.generateViewId();
                btn.setId(id);
                bookMap.put(id, book);
                btn.setOnClickListener(this);
                linearLayout.addView(btn);
            }
        }else if(tag==1){
            status.setText("Books to Return");
            for (Book book : MainActivity.lib.books) {
                if(book.isBorrowed()){
                    Button btn = new Button(this);
                    btn.setText(book.getTitle());
                    int id = View.generateViewId();
                    btn.setId(id);
                    bookMap.put(id, book);
                    btn.setOnClickListener(this);
                    linearLayout.addView(btn);
                }
            }
        }else if(tag==0){
            status.setText("Books Available to Borrow");
            for (Book book : MainActivity.lib.books) {
                if(!book.isBorrowed()){
                    Button btn = new Button(this);
                    btn.setText(book.getTitle());
                    int id = View.generateViewId();
                    btn.setId(id);
                    bookMap.put(id, book);
                    btn.setOnClickListener(this);
                    linearLayout.addView(btn);
                }
            }
        }

    }
}
