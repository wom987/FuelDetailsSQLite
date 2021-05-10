package com.example.examenpractico2.db;

public class Promedio {
    public int id;
    public int imagenKilometros;
    public int imagenCostos;
    public String kilometros;
    public String costos;
    public String titulo;

    public Promedio(int id, int imagenKilometros, int imagenCostos, String kilometros, String costos, String titulo) {
        this.id = id;
        this.imagenKilometros = imagenKilometros;
        this.imagenCostos = imagenCostos;
        this.kilometros = kilometros;
        this.costos = costos;
        this.titulo = titulo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagenKilometros() {
        return imagenKilometros;
    }

    public void setImagenKilometros(int imagenKilometros) {
        this.imagenKilometros = imagenKilometros;
    }

    public int getImagenCostos() {
        return imagenCostos;
    }

    public void setImagenCostos(int imagenCostos) {
        this.imagenCostos = imagenCostos;
    }

    public String getKilometros() {
        return kilometros;
    }

    public void setKilometros(String kilometros) {
        this.kilometros = kilometros;
    }

    public String getCostos() {
        return costos;
    }

    public void setCostos(String costos) {
        this.costos = costos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
