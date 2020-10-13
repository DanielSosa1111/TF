package com.example.tf.ui.pagos;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tf.R;
import com.example.tf.entidades.Pago;

import java.util.ArrayList;
import java.util.List;

public class PagosViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<List<Pago>> listMutableLiveData;
    private Context context;

    public PagosViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<List<Pago>> getListMutableLiveData(){
        if(listMutableLiveData == null){
            listMutableLiveData = new MutableLiveData<>();
        }
        return listMutableLiveData;
    }

    public void cargarLista(){
        ArrayList<Pago> listaPagos = new ArrayList<>();
        listaPagos.add(new Pago("1", "15/02/20", "5000", "TER365", "El Dique 548", R.drawable.casaladrillo1));
        listaPagos.add(new Pago("2", "20/12/20", "1000", "ABC458", "Paraíso 554", R.drawable.casaladrillo2));
        listaPagos.add(new Pago("3", "10/04/20", "2000", "TER345", "Rivera Maya 2018", R.drawable.casaladrillo));

        listMutableLiveData.setValue(listaPagos);
    }
}