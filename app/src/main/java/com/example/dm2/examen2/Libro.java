package com.example.dm2.examen2;

public class Libro {

    private String titulo,autor,editorial;
    private int isbn,paginas;
    private boolean leido;

    public Libro(String tit, String aut, String editorial,int is, int pag, boolean leido){
        this.titulo = tit;
        this.autor = aut;
        this.editorial = editorial;
        this.isbn = is;
        this.paginas = pag;
        this.leido = leido;

    }

    public int getIsbn() {
        return isbn;
    }

    public String getAutor() {
        return autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getTitulo() {
        return titulo;
    }
    public boolean getLeido(){
        return leido;
    }

    public String getLibro(){
        return this;
    }

}
