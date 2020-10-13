package com.example.tf.ui.pagos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

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
import com.example.tf.entidades.Inmueble;
import com.example.tf.ui.adaptadores.AdapterProp;
import com.example.tf.ui.propiedades.PropiedadesViewModel;

import java.util.List;

public class Pagos extends Fragment {

    private com.example.tf.ui.pagos.PagosViewModel mViewModelPagos;
    private com.example.tf.ui.propiedades.PropiedadesViewModel mViewModeProp;
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

    public void inicializar(View view) {

        recyclerViewI = view.findViewById(R.id.recyclerViewProp);
        mViewModeProp = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PropiedadesViewModel.class);

        mViewModeProp.getListMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(final List<Inmueble> inmuebles) {
                recyclerViewI.setLayoutManager(new LinearLayoutManager(getContext()));
                adapterProp = new AdapterProp(getContext(), inmuebles);
                recyclerViewI.setAdapter(adapterProp);


            }
        });

        mViewModeProp.cargarLista();
    }

}