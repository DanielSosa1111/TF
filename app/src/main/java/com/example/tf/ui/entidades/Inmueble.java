package com.example.tf.ui.entidades;

import java.io.Serializable;

public class Inmueble implements Serializable {

    private String codigo, domicilio, ambientes, precio, tipo, uso;
    private int imagenId;
    private boolean estado;

    public Inmueble(){};

    public Inmueble(String codigo, String domicilio, String ambientes, String precio, String tipo, String uso, int imagenId, boolean estado) {
        this.codigo = codigo;
        this.domicilio = domicilio;
        this.ambientes = ambientes;
        this.precio = precio;
        this.tipo = tipo;
        this.uso = uso;
        this.imagenId = imagenId;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(String ambientes) {
        this.ambientes = ambientes;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
