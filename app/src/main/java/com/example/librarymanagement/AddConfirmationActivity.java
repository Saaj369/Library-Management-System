package com.example.librarymanagement;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddConfirmationActivity extends AppCompatActivity {

    public void backPress(View view){
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    public void homepress(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_confirmation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        String addConfirmMSG = intent.getStringExtra(AddActivity.addMSG);
        TextView textviewconfirm = findViewById(R.id.searchResult);
        textviewconfirm.setText(addConfirmMSG);
        textviewconfirm.setTextColor(Color.GREEN);
    }
}