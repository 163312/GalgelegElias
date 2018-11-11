package com.example.elkraft.mingalgeleg;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import java.util.Arrays;
import java.util.HashSet;


public class MainActivity extends AppCompatActivity {
    public static String theWord;
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9;
    ImageView myImage;
    Button startBut, guessBut, exitbut;
    EditText et1;
    Galgelogik spil;
    String gl = "";
    int imageCounter = 0;
    int attemptCounter = 0;
    String notSplit, temp;
    String[] splittet = new String[20];
    String[] theShown = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //startBut = findViewById(R.id.button);
        spil = new Galgelogik();
        guessBut = findViewById(R.id.button2);
        exitbut = findViewById(R.id.button3);

        et1 = findViewById(R.id.et1);

        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);
        tv5 = findViewById(R.id.textView5);
        tv6 = findViewById(R.id.textView6);
        tv7 = findViewById(R.id.textView7);
        tv8 = findViewById(R.id.textView8);
        tv9 = findViewById(R.id.textView9);
        myImage = findViewById(R.id.imageView);

        tv1.setVisibility(View.GONE);
        tv2.setVisibility(View.GONE);
        tv3.setVisibility(View.GONE);
        tv4.setVisibility(View.GONE);
        tv5.setVisibility(View.GONE);
        tv6.setVisibility(View.GONE);


        try {
            spil.asyncTaskStart();
        } catch (Exception e) {
            e.printStackTrace();
        }

        spil.muligeOrd.add("hej");

        spil.logStatus();

        spil.nulstil();

       // for testing
        spil.muligeOrd.clear();
        spil.muligeOrd.add("juhub");
        spil.nulstil();
        notSplit = spil.getOrdet();
        System.out.print(notSplit);
        //spil.manglendeOrd =

        splittet =  notSplit.split("");
        spil.manglendeOrd = "";

        for (int i = 0; splittet.length>i; i++){

        spil.manglendeOrd += splittet[i]+" _ ";

        }

        for (int i = 0; spil.getOrdet().length() > i; i++) {

            theShown[i]=" _ ";
        }
/*
        for (int i = 19; spil.getOrdet().length() < i; i--) {

            theShown[i]=" ";
        }
*/
         temp = "";
        for (String s : theShown){  temp+=s; }
        temp= temp.substring(0,theShown.length);
tv8.setText(temp);
        /*

        tv7.setVisibility(View.GONE);
        tv8.setVisibility(View.GONE);
        tv9.setVisibility(View.GONE);
        myImage.setVisibility(View.GONE);
        et1.setVisibility(View.GONE);
        guessBut.setVisibility(View.GONE);
        exitbut.setVisibility(View.GONE);
        */

    }

    public void onStart(View v) {
        myImage.setVisibility(View.VISIBLE);
        et1.setVisibility(View.VISIBLE);
        startBut.setVisibility(View.GONE);
        guessBut.setVisibility(View.VISIBLE);
        tv7.setVisibility(View.VISIBLE);
        tv8.setVisibility(View.VISIBLE);
        exitbut.setVisibility(View.GONE);

        spil = new Galgelogik();

        // skal aendres til async task



       //String dataS = new hentData().execute();

//spil = hentData.gl;

        //spil.muligeOrd.clear();
        //spil.muligeOrd.addAll(new HashSet<String>(Arrays.asList(dataS.split(" "))));



    }

    public void onGuess(View v) {
    ++attemptCounter;
        if (et1.getText().toString().length() > 1) {
            tv9.setText("Only one letter, you wrote " + et1.getText().toString());
            tv9.setVisibility(View.VISIBLE);
        } else {

            if (gl.contains(et1.getText().toString())) {
                tv9.setText("you have already tried " + et1.getText().toString());
                tv9.setVisibility(View.VISIBLE);
                gl += et1.getText().toString();
            } else {
                gl += et1.getText().toString();
                {


                    tv9.setVisibility(View.GONE);
                    spil.gætBogstav(et1.getText().toString());
                    if (spil.varSidsteBogstavKorrekt()) {

                        for (int i = 0; spil.getOrdet().length()>i; i++){

                            if(splittet[i].equals(et1.getText().toString()) ){
                                theShown[i] = et1.getText().toString();


                            }
                        }

                      //  tv7.setText(spil.getSynligtOrd());
                        temp = "";
                        for (String s : theShown){  temp+=s; }
                        tv7.setText(temp);

                        if (spil.erSpilletVundet()) {

                            //skal have sendt data med
                            Intent i = new Intent(MainActivity.this, won.class);
                            String data = "you won after " + attemptCounter + " attempts";
                            i.putExtra(data, data);
                            finish();
                            startActivity(i);

                            //tv9.setText("you have won !");
                            //tv9.setVisibility(View.VISIBLE);
                            //exitbut.setVisibility(View.VISIBLE);

                        }

                    } else {
                        switch (imageCounter) {

                            case 0:
                                myImage.setImageResource(R.drawable.forkert1);
                                tv1.setVisibility(View.VISIBLE);
                                tv1.setText(et1.getText().toString());
                                imageCounter++;
                                break;

                            case 1:
                                myImage.setImageResource(R.drawable.forkert2);
                                tv2.setVisibility(View.VISIBLE);
                                tv2.setText(et1.getText().toString());
                                imageCounter++;
                                break;

                            case 2:
                                myImage.setImageResource(R.drawable.forkert3);
                                tv3.setVisibility(View.VISIBLE);
                                tv3.setText(et1.getText().toString());
                                imageCounter++;
                                break;

                            case 3:
                                myImage.setImageResource(R.drawable.forkert4);
                                tv4.setVisibility(View.VISIBLE);
                                tv4.setText(et1.getText().toString());
                                imageCounter++;
                                break;

                            case 4:
                                myImage.setImageResource(R.drawable.forkert5);
                                tv5.setVisibility(View.VISIBLE);
                                tv5.setText(et1.getText().toString());
                                imageCounter++;
                                break;

                            case 5:
                                myImage.setImageResource(R.drawable.forkert6);
                                tv6.setVisibility(View.VISIBLE);
                                tv6.setText(et1.getText().toString());
                                imageCounter++;
                                break;

                            case 6:

                                //skal have sendt information med
                                Intent i = new Intent(MainActivity.this, lost.class);
                                notSplit = "The word was: " +notSplit;
                                int a =24;
                                i.putExtra("theWord" , notSplit );
                                finish();
                                startActivity(i);

                                //tv9.setText("you lost!");
                                //tv9.setVisibility(View.VISIBLE);
                                //exitbut.setVisibility(View.VISIBLE);


                        }


                    }
                }

            }
        }
        et1.setText("");
    }

    public void onExit(View v){
        Intent i = new Intent(MainActivity.this, menu.class);
        finish();
        startActivity(i);
       // System.exit(0);

    }


}



















