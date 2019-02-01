package com.example.dm2.examen2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AdaptadorLibros extends ArrayAdapter<Libro> {

    private Libro[] datos;

    public AdaptadorLibros(Context contexto,Libro[]datos){

        super(contexto,R.layout.listitem_libro,datos);
        this.datos = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_libro, null);

        TextView titulo = (TextView) item.findViewById(R.id.titulolibro);
        titulo.setText(datos[position].getTitulo());

        TextView autor = (TextView) item.findViewById(R.id.autirlibro);
        autor.setText(datos[position].getAutor());

        return (item);
    }

}
