package com.example.dm2.examen2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LibrosOpenHelper extends SQLiteOpenHelper{

    public LibrosOpenHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version){

        super(contexto,nombre,factory,version);
    }

    public void onCreate(SQLiteDatabase db) {

        String crearTabla = "CREATE TABLE LIBROS(titulo TEXT,autor TEXT, isbn number(13),editorial TEXT, paginas number(3),leido boolean)";
        db.execSQL(crearTabla);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String borrarTabla = "DROP TABLE LIBROS";
        db.execSQL(borrarTabla);
        String crearTabla = "CREATE TABLE LIBROS(titulo TEXT,autor TEXT, isbn number(13),editorial TEXT, paginas number(3),leido boolean)";
        db.execSQL(crearTabla);
    }
}
