package com.example.entities;

public class Pokemon {
    public String nombre;
    public String tipo;
    public String url_imagen;
    public double latitude;
    public double longitude;

    public Pokemon(String nombre, String tipo, String url_imagen, double latitude, double longitude) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.url_imagen = url_imagen;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
