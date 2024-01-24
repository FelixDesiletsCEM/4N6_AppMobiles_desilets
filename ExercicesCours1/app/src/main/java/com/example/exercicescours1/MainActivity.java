package com.example.exercicescours1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boutonA1 = findViewById(R.id.Activity_A1);
        boutonA1.setOnClickListener(View -> {
                                                        Intent intent = new Intent(MainActivity.this, ActivityA1.class);
                                                        startActivity(intent);
                                                    });
        Button boutonA2 = findViewById(R.id.Activity_A2);
        boutonA2.setOnClickListener(View -> {
            Intent intent = new Intent(MainActivity.this, ActivityA2.class);
            startActivity(intent);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_gotoMain) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_gotoA1) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            return true;
        }
        if (id == R.id.action_gotoA2) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}