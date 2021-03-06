package com.example.tf.entidades;

import java.io.Serializable;

public class Contrato implements Serializable {

    private String dir, fStart, fEnd, precio;
    int imagenIdCont;

    public Contrato(){};

    public Contrato(String dir, String fStart, String fEnd, String precio, int imagenIdCont) {
        this.dir = dir;
        this.fStart = fStart;
        this.fEnd = fEnd;
        this.precio = precio;
        this.imagenIdCont = imagenIdCont;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getfStart() {
        return fStart;
    }

    public void setfStart(String fStart) {
        this.fStart = fStart;
    }

    public String getfEnd() {
        return fEnd;
    }

    public void setfEnd(String fEnd) {
        this.fEnd = fEnd;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getImagenIdCont() {
        return imagenIdCont;
    }

    public void setImagenIdCont(int imagenIdCont) {
        this.imagenIdCont = imagenIdCont;
    }
}
