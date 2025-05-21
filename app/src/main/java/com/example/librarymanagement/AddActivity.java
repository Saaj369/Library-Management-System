package com.example.librarymanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddActivity extends AppCompatActivity {
    public static final String addMSG = "com.saaj.LibraryManagement.addMSG";
    public void add_Book(View view){
        EditText title = findViewById(R.id.searchtitleField);
        EditText author = findViewById(R.id.authorField);
        String titleStr = title.getText().toString();
        String authorStr = author.getText().toString();
        if(!titleStr.isEmpty()){
            if(MainActivity.lib.searchTitle(titleStr) == -1){
                MainActivity.lib.addBook(title.getText().toString(),author.getText().toString());
                Intent intent = new Intent(this,AddConfirmationActivity.class);
                String addConfirmMSG = "Title : " + title.getText().toString() + "\nAuthor : " + author.getText().toString() + "\nBook added successfully.";
                Toast.makeText(this, "Added Book Successfully...", Toast.LENGTH_SHORT).show();

                intent.putExtra(addMSG,addConfirmMSG);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "This Book is already Present in the Library.", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Please Enter a Valid Book name.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        EditText title = findViewById(R.id.searchtitleField);
        EditText author = findViewById(R.id.authorField);
        title.setText("");
        author.setText("");
    }
}