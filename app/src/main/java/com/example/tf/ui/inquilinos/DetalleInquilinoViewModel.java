package com.example.tf.ui.inquilinos;


import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tf.entidades.Inquilino;


public class DetalleInquilinoViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Inquilino> inquilinos;
    public DetalleInquilinoViewModel(){super();}
    public LiveData<Inquilino> getInquilinos(){

        if(inquilinos==null){
            inquilinos=new MutableLiveData<>();
        }
        return inquilinos;
    }

    public void cargarInquilino(Bundle bundle){

        Inquilino inq = (Inquilino) bundle.getSerializable("datosInq");
        Log.d("salida", inq+"");
        inquilinos.setValue(inq);

    }
}