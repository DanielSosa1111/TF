package com.example.tf.ui.contratos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.tf.R;
import com.example.tf.entidades.Contrato;

public class DetalleContratos extends Fragment {

    private DetalleContratosViewModel mViewModel;
    private EditText fi, ff, precio;

    public static DetalleContratos newInstance() {
        return new DetalleContratos();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contratos_detalle, container, false);
        inicializar(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = ViewModelProviders.of(this).get(DetalleContratosViewModel.class);
        // TODO: Use the ViewModel
    }

    public void inicializar(View view){

        fi = view.findViewById(R.id.etFechaContratos);
        ff = view.findViewById(R.id.etfFinalContratos);
        precio = view.findViewById(R.id.etPrecioContratos);

        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(DetalleContratosViewModel.class);
        mViewModel.getContratos().observe(getViewLifecycleOwner(), new Observer<Contrato>() {
            @Override
            public void onChanged(Contrato contrato) {

                fi.setText(contrato.getfStart());
                ff.setText(contrato.getfEnd());
                precio.setText(contrato.getPrecio());

            }
        });

        mViewModel.cargarContratos(getArguments());
    }

}