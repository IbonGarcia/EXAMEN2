package com.example.dm2.examen2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class ListadoLibros extends AppCompatActivity {


    private ListView listaV;
    private SQLiteDatabase db;
    private RadioButton leidos,noleidos,todos;
    private RadioGroup grupo;
    private Context contexto;
    private ArrayList<Libro> libs;
    private  Libro [] libros;
    private String titulo,autor;
    private Libro nuevoLibro;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_libros);

        LibrosOpenHelper ldb = new LibrosOpenHelper(this, "DBLibros", null, 1);
        db=ldb.getWritableDatabase();

        contexto = this.getApplicationContext();
        listaV = findViewById(R.id.lista);
        grupo = findViewById(R.id.grupo);
        leidos = findViewById(R.id.leidos);
        noleidos = findViewById(R.id.noleidos);
        todos = findViewById(R.id.todos);
        libs = new ArrayList<>();

        leidos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Cursor info = db.rawQuery("SELECT titulo,autor FROM LIBROS WHERE leido='"+true+"'",null);
                if (info.moveToFirst()){

                    while(info.moveToNext()){
                        titulo = info.getString(0);
                        autor = info.getString(1);
                        nuevoLibro = new Libro(titulo,autor,"",0,0,true);
                        libs.add(nuevoLibro);
                    }
                    libros = new Libro[libs.size()];
                    libs.toArray(libros);

                    // ADAPTADOR
                    AdaptadorLibros adaptador = new AdaptadorLibros(contexto,libros);
                    listaV.setAdapter(adaptador);
                }
            }
        });
        noleidos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String titulo="";
                String autor="";
                Libro nuevoLibro;
                libs = new ArrayList<>();
                Cursor info = db.rawQuery("SELECT titulo,autor FROM LIBROS WHERE leido='"+false+"'",null);
                if (info.moveToFirst()){

                    while(info.moveToNext()){
                        titulo = info.getString(0);
                        autor = info.getString(1);
                        nuevoLibro = new Libro(titulo,autor,"",0,0,true);
                        libs.add(nuevoLibro);
                    }
                    libros = new Libro[libs.size()];
                    libs.toArray(libros);

                    // ADAPTADOR
                    AdaptadorLibros adaptador = new AdaptadorLibros(contexto,libros);
                    listaV.setAdapter(adaptador);
                }
            }
        });
        todos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String titulo="";
                String autor="";
                Libro nuevoLibro;
                libs = new ArrayList<>();
                Cursor info = db.rawQuery("SELECT titulo,autor FROM LIBROS",null);
                if (info.moveToFirst()){

                    while(info.moveToNext()){
                        titulo = info.getString(0);
                        autor = info.getString(1);
                        nuevoLibro = new Libro(titulo,autor,"",0,0,true);
                        libs.add(nuevoLibro);
                    }
                    libros = new Libro[libs.size()];
                    libs.toArray(libros);

                    // ADAPTADOR
                    AdaptadorLibros adaptador = new AdaptadorLibros(contexto,libros);
                    listaV.setAdapter(adaptador);
                }
            }
        });

        listaV.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intento = new Intent(getApplicationContext(),InformacionLibro.class);
                intento.putExtra("libro",libros[position].getLibro());
                // NO ME HA DADO TIEMPO HA HACER LO DE LA INFORMAICON COMPLETA DEL LIBRO
                startActivity(intento);
            }
        });
    }

    public void volver(View view){
        System.exit(1);
    }
}
