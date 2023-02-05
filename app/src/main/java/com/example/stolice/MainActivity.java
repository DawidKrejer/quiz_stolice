package com.example.stolice;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button europa, azja;
    ImageButton cisza,dzwiek;


    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dzwiek=(ImageButton)findViewById(R.id.imagedzwiek);
        cisza=(ImageButton)findViewById(R.id.imagecisza);

        dzwiek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer==null){
                    mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.muzyka1);
                }
                mediaPlayer.start();
            }
        });

        cisza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer!=null){
                    mediaPlayer.pause();
                }
            }
        });

        europa = findViewById(R.id.europa);

        europa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);

            }
        });

        azja = findViewById(R.id.azja);


        azja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_quiz_azja.class);
                startActivity(intent);

            }
        });


    }
}