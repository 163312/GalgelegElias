package com.example.elkraft.mingalgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.elkraft.mingalgeleg.R;

public class lost extends AppCompatActivity {
TextView tvLost;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);
        Intent i = getIntent();
        String message = i.getStringExtra(MainActivity.theWord);
        //String the = "theWord"
        //Stri a = i.getStringArrayExtra(the);
        Button playBut = (Button) findViewById(R.id.paButton2);
        Button retBut = (Button) findViewById(R.id.returnButton2);
         tvLost = findViewById(R.id.textView10);
         tvLost.setText(message);

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



    //fra won



    public void onPlay(View v){
        Intent i = new Intent(lost.this, menu.class);
        finish();
        startActivity(i);


    }

    public void onReturn(View v){
        Intent i = new Intent(lost.this, MainActivity.class);
        finish();
        startActivity(i);


    }

}
