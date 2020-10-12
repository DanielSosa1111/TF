package com.example.tf.ui.propiedades;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tf.R;
import com.example.tf.ui.entidades.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class PropiedadesViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<List<Inmueble>> listMutableLiveData;
    private Context context;

    public PropiedadesViewModel(@NonNull Application application){
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<List<Inmueble>> getListMutableLiveData() {

        if (listMutableLiveData==null){
            listMutableLiveData=new MutableLiveData<>();
        }
        return listMutableLiveData;
    }

    public void cargarLista(){
        ArrayList<Inmueble> listaInmuebles= new ArrayList<>();
        listaInmuebles.add(new Inmueble("TER365","El Dique 548", "3", "25000", "casa","privado", R.drawable.casaladrillo1,true));
        listaInmuebles.add(new Inmueble("ABC458","Paraíso 554", "4", "30000", "cAsa", "pRivado",R.drawable.casaladrillo2,false));
        listaInmuebles.add(new Inmueble("TER345","Rivera Maya 2018", "5", "35000", "caSa", "prIvado",R.drawable.casaladrillo, false));

        listMutableLiveData.setValue(listaInmuebles);
    }
}