package com.example.tf.ui.perfil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tf.entidades.PerfilDatos;

public class PerfilViewModel extends ViewModel {

    private MutableLiveData<PerfilDatos> perfilDatos;

    public LiveData<PerfilDatos> getPerfil(){

        if(perfilDatos==null){
            perfilDatos=new MutableLiveData<>();
        }
        return perfilDatos;
    }

    public void obtenerPerfilD(){
            PerfilDatos p=new PerfilDatos("26329315","SOSA","Daniel","456789","dani@","1234");
            perfilDatos.setValue(p);
    }
}