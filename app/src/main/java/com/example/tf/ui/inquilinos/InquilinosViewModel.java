package com.example.tf.ui.inquilinos;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tf.R;
import com.example.tf.ui.entidades.Inquilino;

import java.util.ArrayList;
import java.util.List;

public class InquilinosViewModel extends AndroidViewModel {
    private MutableLiveData<List<Inquilino>> inquilinos;
    private Context context;

    public InquilinosViewModel(@NonNull Application application){

        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<List<Inquilino>> getInquilinos(){
        if(inquilinos==null){
            inquilinos = new MutableLiveData<>();
        }
        return inquilinos;
    }

    public void cargarInquilinos(){

        ArrayList<Inquilino> inquilinos = new ArrayList<>();
        inquilinos.add(new Inquilino("26387598", "Simpson", "Bart", "Springfiled 1", "458*985*", R.drawable.bart));
        inquilinos.add(new Inquilino("26454598", "Simpson", "Lisa", "Springfiled 2", "458*985*", R.drawable.lisa));
        inquilinos.add(new Inquilino("23457598", "Simpson", "Maggie", "Springfiled 3", "458*985*", R.drawable.maggie));
        this.inquilinos.setValue(inquilinos);
    }
}
