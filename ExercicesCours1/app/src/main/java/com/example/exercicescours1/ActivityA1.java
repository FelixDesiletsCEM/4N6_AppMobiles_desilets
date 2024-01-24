package com.example.exercicescours1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityA1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

        Button boutonA1 = findViewById(R.id.Activity_A2);
        boutonA1.setOnClickListener(View -> {
            Intent intent = new Intent(ActivityA1.this, ActivityA2.class);
            startActivity(intent);
        });
        Button bouton0 = findViewById(R.id.Activity_main);
        bouton0.setOnClickListener(View -> {
            Intent intent = new Intent(ActivityA1.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
