package com.example.tpfinal;

public class Pago {
    String importe,nroPago,fechaPago;

    public Pago(String importe, String nroPago, String fechaPago) {
        this.importe = importe;
        this.nroPago = nroPago;
        this.fechaPago = fechaPago;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getNroPago() {
        return nroPago;
    }

    public void setNroPago(String nroPago) {
        this.nroPago = nroPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }
}
