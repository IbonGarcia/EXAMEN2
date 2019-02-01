package com.example.dm2.examen2;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class NuevoLibro extends AppCompatActivity {

    private EditText tit,autor,isbn,edit,pag;
    private CheckBox leido;
    private SQLiteDatabase db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_libro);

        tit = findViewById(R.id.edititulo);
        autor = findViewById(R.id.editautor);
        isbn = findViewById(R.id.editisbn);
        edit = findViewById(R.id.editeditorial);
        pag = findViewById(R.id.editpag);
        leido = findViewById(R.id.leido);

        // ABRIMOS LA BBDD
        LibrosOpenHelper ldb = new LibrosOpenHelper(this, "DBLibros", null, 1);
        db = ldb.getWritableDatabase();

    }
    public void insertar(View view){
        String titulo = tit.getText().toString();
        String aut = autor.getText().toString();
        int is = Integer.parseInt(isbn.getText().toString());
        String editorial = edit.getText().toString();
        int paginas = Integer.parseInt(pag.getText().toString());
        boolean l;
        if (leido.isChecked()){
            l = true;
        }
        else{
            l = false;
        }
        if (l=true){
            db.execSQL("INSERT INTO LIBROS VALUES('"+titulo+"', '"+aut+"', "+is+", '"+editorial+"', "+paginas+",'"+true+"')");
        }
        else{
            db.execSQL("INSERT INTO LIBROS VALUES('"+titulo+"', '"+aut+"', "+is+", '"+editorial+"',"+paginas+",'"+false+"')");
        }
        cancelar(view);
    }

    public void cancelar(View view){
        tit.setText("");
        autor.setText("");
        isbn.setText("");
        edit.setText("");
        pag.setText("");
        leido.setChecked(false);
    }

    public void volver(View view){
        db.close();
        System.exit(1);
    }
}
