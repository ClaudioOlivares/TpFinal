package com.example.tpfinal;

import android.widget.ImageView;

public class Propiedad {
    int foto ;
    String Precio,Direccion;

    public Propiedad(int foto, String precio, String direccion) {
        this.foto = foto;
        Precio = precio;
        Direccion = direccion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
}
