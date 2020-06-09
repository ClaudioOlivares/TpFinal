package com.example.tpfinal.models;

import java.io.Serializable;

public class TipoInmueble  implements Serializable   {
    private int idTipoInmueble;
    private String nombreTipo;

    public TipoInmueble() {
    }

    public TipoInmueble(int idTipoInmueble, String nombreTipo) {
        this.idTipoInmueble = idTipoInmueble;
        this.nombreTipo = nombreTipo;
    }

    public int getIdTipoInmueble() {
        return idTipoInmueble;
    }

    public void setIdTipoInmueble(int idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
}
