package com.example.dm2.examen2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InformacionLibro extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_libro);

        Bundle extras = getIntent().getExtras();
        // NO ME HA DADO TIEMPO

    }



    public void cancelar(View view){
        System.exit(1);
    }
}
