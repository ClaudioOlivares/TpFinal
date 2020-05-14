package com.example.tpfinal;

public class Inquilino {
    String nombre,apellido,dni,trabajo;

    public Inquilino(String nombre, String apellido, String dni, String trabajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.trabajo = trabajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }
}
