package com.example.activitesb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText texte = findViewById(R.id.edt_editText);

        Button bouton1B = findViewById(R.id.btn_bouton);
        bouton1B.setOnClickListener(View -> {Intent intent = new Intent(MainActivity.this, Activity1B.class);
            intent.putExtra("allo", texte.getText().toString());
            startActivity(intent);
        });
    }
}