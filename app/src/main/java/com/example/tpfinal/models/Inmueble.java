package com.example.tpfinal.models;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Inmueble implements Serializable {
    private  int idInmueble;
    private Propietario propietario;
    private int idPropietario;
    private String direccion;
    private TipoInmueble tipoInmueble;
    private int idTipoInmueble;
    private int cantAmbientes;
    private double precio;
    private Boolean estado;

    public Inmueble() {
    }

    public Inmueble(int idInmueble, Propietario propietario, int idPropietario, String direccion, TipoInmueble tipoInmueble, int idTipoInmueble, int cantAmbientes, double precio, Boolean estado) {
        this.idInmueble = idInmueble;
        this.propietario = propietario;
        this.idPropietario = idPropietario;
        this.direccion = direccion;
        this.tipoInmueble = tipoInmueble;
        this.idTipoInmueble = idTipoInmueble;
        this.cantAmbientes = cantAmbientes;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoInmueble getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(TipoInmueble tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public int getIdTipoInmueble() {
        return idTipoInmueble;
    }

    public void setIdTipoInmueble(int idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
    }

    public int getCantAmbientes() {
        return cantAmbientes;
    }

    public void setCantAmbientes(int cantAmbientes) {
        this.cantAmbientes = cantAmbientes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
