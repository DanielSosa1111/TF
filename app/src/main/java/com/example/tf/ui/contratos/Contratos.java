package com.example.tf.ui.contratos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

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
import com.example.tf.ui.adaptadores.AdapterContratos;
import com.example.tf.entidades.Contrato;

import java.util.List;

public class Contratos extends Fragment {

    private com.example.tf.ui.contratos.ContratosViewModel mViewModel;
    private Context context;
    private AdapterContratos adapterContratos;
    private RecyclerView recyclerView;

    public static Contratos newInstance() {
        return new Contratos();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contratos_rv, container, false);
        context = view.getContext();
        inicializar(view);
        return view;
    }

   public void inicializar(View view){

        recyclerView = view.findViewById(R.id.contratosRv);
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratosViewModel.class);

        mViewModel.getListMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Contrato>>() {
            @Override
            public void onChanged(List<Contrato> contratos) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                adapterContratos = new AdapterContratos(getContext(), contratos);
                recyclerView.setAdapter(adapterContratos);

            }
        });
        mViewModel.cargaLista();
   }
}