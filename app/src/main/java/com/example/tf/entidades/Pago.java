package com.example.tf.entidades;

import java.io.Serializable;

public class Pago implements Serializable {

    String nPago, fecha, importe, codInm, dom;
    int imagenIdPagos;

    public Pago(String nPago, String fecha, String importe, String codInm, String dom, int imagenIdPagos) {
        this.nPago = nPago;
        this.fecha = fecha;
        this.importe = importe;
        this.codInm = codInm;
        this.dom = dom;
        this.imagenIdPagos = imagenIdPagos;
    }

    public String getnPago() {
        return nPago;
    }

    public void setnPago(String nPago) {
        this.nPago = nPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getCodInm() {
        return codInm;
    }

    public void setCodInm(String codInm) {
        this.codInm = codInm;
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public int getImagenIdPagos() {
        return imagenIdPagos;
    }

    public void setImagenIdPagos(int imagenIdPagos) {
        this.imagenIdPagos = imagenIdPagos;
    }
}
