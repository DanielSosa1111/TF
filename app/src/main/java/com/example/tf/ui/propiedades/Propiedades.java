package com.example.tf.ui.propiedades;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tf.R;
import com.example.tf.ui.adaptadores.AdapterProp;
import com.example.tf.ui.entidades.Inmueble;

import java.util.List;

public class Propiedades extends Fragment {

    private com.example.tf.ui.propiedades.PropiedadesViewModel mViewModel;
    private AdapterProp adapterProp;
    private RecyclerView recyclerViewI;
    private Context context;


    Activity actividad;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.propiedades_fragment, container, false);
        context = view.getContext();
        inicializar(view);
        return view;
    }


    public void inicializar(View view){

        recyclerViewI= view.findViewById(R.id.recyclerViewProp);
        mViewModel= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PropiedadesViewModel.class);

        mViewModel.getListMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(final List<Inmueble> inmuebles) {
                recyclerViewI.setLayoutManager(new LinearLayoutManager(getContext()));
                adapterProp = new AdapterProp(getContext(), inmuebles);
                recyclerViewI.setAdapter(adapterProp);


            }
        });

        mViewModel.cargarLista();


    }



}