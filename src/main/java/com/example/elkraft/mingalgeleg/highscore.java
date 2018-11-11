package com.example.elkraft.mingalgeleg;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.elkraft.mingalgeleg.R;

public class highscore extends AppCompatActivity {
    Button returnBut;
    String[] scoreName = {"karl", "Jens"};
    Integer[] scoreNumb = {5, 7};
    Integer[] scoreRank = {1, 2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        returnBut = findViewById(R.id.highscoreButton3);

        ListView lvName = (ListView) findViewById(R.id.list3);
        ListAdapter laName = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, scoreName );
                lvName.setAdapter(laName);

        ListView lvNumb = (ListView) findViewById(R.id.list2);
        ListAdapter laNumb = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, scoreNumb );
        lvNumb.setAdapter(laNumb);

        ListView lvRank = (ListView) findViewById(R.id.list1);
        ListAdapter laRank = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, scoreRank );
        lvRank.setAdapter(laRank);

        ;



    }



public void onHSReturn(View v){
    Intent i = new Intent(highscore.this, menu.class);
    finish();
    startActivity(i);

        }


}
