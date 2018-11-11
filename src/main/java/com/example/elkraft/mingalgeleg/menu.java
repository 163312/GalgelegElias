package com.example.elkraft.mingalgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.elkraft.mingalgeleg.MainActivity;
import com.example.elkraft.mingalgeleg.R;
import com.example.elkraft.mingalgeleg.highscore;

public class menu extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button exitBut = (Button) findViewById(R.id.exitButton);
        Button startBut = (Button) findViewById(R.id.startButton);
        Button hsBut = (Button) findViewById(R.id.highscoreButton);


        exitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onExit();
            }
        });

        startBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onPlay(view);
            }
        });

        hsBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onHighscore(view);
            }
        });




    }

    public void onExit(){
        finish();
    }

    public void onPlay(View v){
        Intent i = new Intent(menu.this, MainActivity.class);
        finish();
        startActivity(i);


    }

    public void onHighscore(View V){
        Intent i = new Intent(menu.this, highscore.class);
        finish();
        startActivity(i);

    }


}
