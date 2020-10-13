package com.example.tf.ui.contratos;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tf.entidades.Contrato;
import com.example.tf.entidades.Inquilino;

public class DetalleContratosViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<Contrato> contratos;
    //public DetalleInquilinoViewModel(){super();}
    public LiveData<Contrato> getContratos(){

        if(contratos==null){
            contratos=new MutableLiveData<>();
        }
        return contratos;
    }

    public void cargarContratos(Bundle bundle){

        Contrato con = (Contrato) bundle.getSerializable("datosContrato");
        Log.d("salida", con+"");
        contratos.setValue(con);

    }
}