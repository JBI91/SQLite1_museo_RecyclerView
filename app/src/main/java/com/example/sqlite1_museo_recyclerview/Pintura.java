package com.example.sqlite1_museo_recyclerview;

public class Pintura {
    Long id;
    String titulo;
    String autor;
    int anio;

    public Pintura(Long id, String titulo,
                   String autor, int anio) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Pintura{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anio=" + anio +
                '}';
    }

}