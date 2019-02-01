package com.example.dm2.examen2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Libros extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros);
    }

    public void nuevo(View view){
        Intent intento = new Intent(getApplicationContext(),NuevoLibro.class);
        startActivity(intento);
    }

    public void listado(View view){
        Intent intento = new Intent(getApplicationContext(),ListadoLibros.class);
        startActivity(intento);
    }

    public void buscar(View view){
        Intent intento = new Intent(getApplicationContext(),buscar.class);
        startActivity(intento);
    }

    public void atras(View view){
        System.exit(1);
    }
}
