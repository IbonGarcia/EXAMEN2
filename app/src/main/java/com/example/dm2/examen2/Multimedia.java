package com.example.dm2.examen2;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Multimedia extends AppCompatActivity {

    private Spinner spinner;
    MediaPlayer mediaplayer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);

        spinner = findViewById(R.id.spinner);
        mediaplayer = MediaPlayer.create(this,R.raw.burro);

        InputStream is = getResources().openRawResource(R.raw.animales);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String datos[] = new String[8];
        try {
            int cont =0;
            String linea = br.readLine();
            while(linea!=null){
                datos[cont] = linea;
                linea = br.readLine();
                cont++;
            }
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,datos);
            spinner.setAdapter(adaptador);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String animal = (String) spinner.getSelectedItem();
                    switch (animal){
                        case "BURRO":
                            play("BURRO");
                            break;
                        case "CABALLO":
                            play("CABALLO");
                            break;
                        case "CABRA":
                            play("CABRA");
                            break;
                        case "GALLINA":
                            play("GALLINA");
                            break;
                        case "GALLO":
                            play("GALLO");
                            break;
                        case "GATO":
                            play("GATO");
                            break;
                        case "OVEJA":
                            play("OVEJA");
                            break;
                        case "VACA":
                            play("VACA");
                            break;

                    }
                }
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play(String animal){
        if (animal.equals("BURRO")){
            mediaplayer.pause();
            mediaplayer = MediaPlayer.create(this,R.raw.burro);
            mediaplayer.start();
        }
        if (animal.equals("CABALLO")){
            mediaplayer.pause();
            mediaplayer = MediaPlayer.create(this,R.raw.caballos);
            mediaplayer.start();
        }
        if (animal.equals("CABRA")){
            mediaplayer.pause();
            mediaplayer = MediaPlayer.create(this,R.raw.cabra);
            mediaplayer.start();
        }
        if (animal.equals("GALLINA")){
            mediaplayer.pause();
            mediaplayer = MediaPlayer.create(this,R.raw.gallina);
            mediaplayer.start();
        }
        if (animal.equals("GALLO")){
            mediaplayer = MediaPlayer.create(this,R.raw.gallo);
            mediaplayer.start();
        }
        if (animal.equals("GATO")){
            mediaplayer.pause();
            mediaplayer = MediaPlayer.create(this,R.raw.gato);
            mediaplayer.start();
        }
        if (animal.equals("OVEJA")){
            mediaplayer = MediaPlayer.create(this,R.raw.ovejas);
            mediaplayer.start();
        }
        if (animal.equals("VACA")){
            mediaplayer.pause();
            mediaplayer = MediaPlayer.create(this,R.raw.vaca);
            mediaplayer.start();
        }
    }

    public void volver(View view){
        System.exit(1);
    }


}
