package com.example.tf.ui.propiedades;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tf.ui.entidades.Inmuebles;

public class DetallePropiedadViewModel extends ViewModel {
    // TODO: Implement the ViewModel
   private MutableLiveData<Inmuebles> inmuebles;
   public DetallePropiedadViewModel(){super();}
   public LiveData<Inmuebles> getInmuebles(){

       if(inmuebles==null){
           inmuebles=new MutableLiveData<>();
       }
       return inmuebles;
   }

   public void cargarInmueble(Bundle bundle){

       Inmuebles inmu = (Inmuebles) bundle.getSerializable("datosProp");
       inmuebles.setValue(inmu);

   }

}