package com.example.stolice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class wynik_quizu extends AppCompatActivity {
    TextView wynikk;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wynik_quizu);

        wynikk=findViewById(R.id.rezultat);

        int poprawne = getIntent().getIntExtra("wynik2", 0);
        wynikk.setText("" + poprawne);
        home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(wynik_quizu.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }
}