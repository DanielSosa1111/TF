package com.example.tf.ui.pagos;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tf.entidades.Pago;

public class DetallePagosViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<Pago> pagos;
    public LiveData<Pago> getPagos(){
        if(pagos==null){
            pagos=new MutableLiveData<>();
        }
        return pagos;
    }

    public void cargarPagos(Bundle bundle){

        Pago pag = (Pago) bundle.getSerializable("datosPagos");
        pagos.setValue(pag);
    }
}