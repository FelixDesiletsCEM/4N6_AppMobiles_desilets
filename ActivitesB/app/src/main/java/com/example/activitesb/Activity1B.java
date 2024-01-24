package com.example.activitesb;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity1B extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1b);

        Intent intentInitial = getIntent();
        String LeTexteÀAfficher = intentInitial.getStringExtra("allo");

        TextView Letexte = findViewById(R.id.tv_texte);
        Letexte.setText(LeTexteÀAfficher);

        Button boutonMain = findViewById(R.id.btn_retour);
        boutonMain.setOnClickListener(View -> {
            Intent intent = new Intent(Activity1B.this, MainActivity.class);

            startActivity(intent);
        });
    }
}
