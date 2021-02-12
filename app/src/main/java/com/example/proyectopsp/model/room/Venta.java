package com.example.proyectopsp.model.room;

public class Venta {
    String marca, modelo,foto;
    long id;

    public Venta(){}

    public Venta(String marca, String modelo, String foto) {
        this.marca = marca;
        this.modelo = modelo;
        this.foto = foto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return marca + " " +  modelo;
    }
}
