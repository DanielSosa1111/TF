package com.example.tf.ui.inquilinos;


import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tf.ui.entidades.Inquilino;


public class DetalleInquilinoViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Inquilino> inquilino;
    public DetalleInquilinoViewModel(){super();}
    public LiveData<Inquilino> getInquilino(){

        if(inquilino==null){
            inquilino=new MutableLiveData<>();
        }
        return inquilino;
    }

    public void cargarInquilino(Bundle bundle){

        Inquilino inq = (Inquilino) bundle.getSerializable("datosInq");
        inquilino.setValue(inq);

    }
}