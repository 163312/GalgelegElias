package com.example.elkraft.mingalgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.elkraft.mingalgeleg.R;

public class won extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);
        Intent i= getIntent();
        String message = i.getDataString();
        Button playBut = (Button) findViewById(R.id.paButton);
        Button retBut = (Button) findViewById(R.id.returnButton);

        playBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onPlay(view);
            }
        });

        retBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onReturn(view);
            }
        });




    }
    public void onPlay(View v){
        Intent i = new Intent(won.this, MainActivity.class);
        finish();
        startActivity(i);


    }

    public void onReturn(View v){
        Intent i = new Intent(won.this, menu.class);
        finish();
        startActivity(i);


    }



}
