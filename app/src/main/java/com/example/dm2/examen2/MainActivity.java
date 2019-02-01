package com.example.dm2.examen2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bbdd(View view){
        Intent intento = new Intent(getApplicationContext(),Libros.class);
        startActivity(intento);
    }

    public void multi(View view){
        Intent intento = new Intent(getApplicationContext(),Multimedia.class);
        startActivity(intento);
    }

    public void salir(View view){
        System.exit(1);
    }
}
