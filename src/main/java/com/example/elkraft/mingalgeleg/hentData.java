package com.example.elkraft.mingalgeleg;

import android.os.AsyncTask;

import java.util.Arrays;

public class hentData extends AsyncTask {
    public Galgelogik gl;
    String data = "";


    public hentData() {

    }

    protected Object doInBackground(Object[] objects) {
         data = "";
        try {
            data = gl.hentUrl("https://dr.dk");
            //System.out.println("data = " + data);

            data = data.substring(data.indexOf("<body")). // fjern headere
                    replaceAll("<.+?>", " ").toLowerCase(). // fjern tags
                    replaceAll("&#198;", "æ"). // erstat HTML-tegn
                    replaceAll("&#230;", "æ"). // erstat HTML-tegn
                    replaceAll("&#216;", "ø"). // erstat HTML-tegn
                    replaceAll("&#248;", "ø"). // erstat HTML-tegn
                    replaceAll("&oslash;", "ø"). // erstat HTML-tegn
                    replaceAll("&#229;", "å"). // erstat HTML-tegn
                    replaceAll("[^a-zæøå]", " "). // fjern tegn der ikke er bogstaver
                    replaceAll(" [a-zæøå] "," "). // fjern 1-bogstavsord
                    replaceAll(" [a-zæøå][a-zæøå] "," "); // fjern 2-bogstavsord

            System.out.println("data = " + data);
            System.out.println("data = " + Arrays.asList(data.split("\\s+")));        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(" kunne ikke hente ord fra DR ");
        }
        return data;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        return;
    }







}
