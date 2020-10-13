package com.example.tf.ui.propiedades;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tf.entidades.Inmueble;

public class DetallePropiedadViewModel extends ViewModel {
    // TODO: Implement the ViewModel
   private MutableLiveData<Inmueble> inmuebles;
   public DetallePropiedadViewModel(){super();}
   public LiveData<Inmueble> getInmuebles(){

       if(inmuebles==null){
           inmuebles=new MutableLiveData<>();
       }
       return inmuebles;
   }

   public void cargarInmueble(Bundle bundle){

       Inmueble inmu = (Inmueble) bundle.getSerializable("datosProp");
       inmuebles.setValue(inmu);

   }

}