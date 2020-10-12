package com.example.tf.ui.entidades;

import java.io.Serializable;

public class Inquilino implements Serializable {

    String dni, apellido, nombre, direccion, tel;
    private int imagenIdInq;

    public Inquilino(){

    }

    public Inquilino(String dni, String apellido, String nombre, String direccion, String tel, int imagenIdInq) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tel = tel;
        this.imagenIdInq = imagenIdInq;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getImagenIdInq() {
        return imagenIdInq;
    }

    public void setImagenIdInq(int imagenIdInq) {
        this.imagenIdInq = imagenIdInq;
    }
}
