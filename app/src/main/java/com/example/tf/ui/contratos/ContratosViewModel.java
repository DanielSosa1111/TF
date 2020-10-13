package com.example.tf.ui.contratos;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tf.R;
import com.example.tf.ui.entidades.Contrato;

import java.util.ArrayList;
import java.util.List;

public class ContratosViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<List<Contrato>> listMutableLiveData;
    private Context context;


    public ContratosViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<List<Contrato>> getListMutableLiveData() {
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<>();
        }
        return listMutableLiveData;
    }

    public void cargaLista(){
        ArrayList<Contrato> listaContratos = new ArrayList<>();
        listaContratos.add(new Contrato("El Dique 548","02/05/20","02/05/22","5000", R.drawable.casaladrillo1));
        listaContratos.add(new Contrato("Paraíso 554","03/02/20","03/02/22","6000", R.drawable.casaladrillo2));
        listaContratos.add(new Contrato("Rivera Maya 2018","25/12/20","03/02/22","3000", R.drawable.casaladrillo));

        listMutableLiveData.setValue(listaContratos);
    }
}