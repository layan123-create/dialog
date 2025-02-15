package com.example.dialog;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView welcomeText = findViewById(R.id.welcome);
        String username = getIntent().getStringExtra("username");

        welcomeText.setText("Welcome " + username);
    }
}