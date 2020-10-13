package com.example.tf.entidades;

public class PerfilDatos {

    private String dni,apell,nom,tel,email,pass;

    public PerfilDatos(String dni, String apell, String nom, String tel, String email, String pass) {
        this.dni = dni;
        this.apell = apell;
        this.nom = nom;
        this.tel = tel;
        this.email = email;
        this.pass = pass;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApell() {
        return apell;
    }

    public void setApell(String apell) {
        this.apell = apell;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setDatos(){

        dni="26329315";
        apell="SOSA";
        nom="Ricardo Daniel";
        tel="32323232";
        email="dani@fgfds";
        pass="4564dfss";

    }
}
