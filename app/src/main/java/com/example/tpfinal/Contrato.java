package com.example.tpfinal;

import java.util.Date;

public class Contrato {
    String fechaInicio,fechaFinal;
    String precio,direccion;

    public Contrato(String fechaInicio,String fechaFinal, String precio,String direccion) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.precio = precio;
        this.direccion = direccion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
