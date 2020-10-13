package com.example.tf.ui.pagos;

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
import com.example.tf.entidades.Pago;

public class DetallePagos extends Fragment {

    private DetallePagosViewModel mViewModel;
    private EditText nPago, fPago, impPago;

    public static DetallePagos newInstance() {
        return new DetallePagos();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pago_detalle, container, false);
        inicializar(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DetallePagosViewModel.class);
        // TODO: Use the ViewModel
    }

    public void inicializar(View view){

        nPago = view.findViewById(R.id.etNroPago);
        fPago = view.findViewById(R.id.etFechaPagos);
        impPago = view.findViewById(R.id.etImportePagos);

        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(DetallePagosViewModel.class);
        mViewModel.getPagos().observe(getViewLifecycleOwner(), new Observer<Pago>() {
            @Override
            public void onChanged(Pago pago) {

                nPago.setText(pago.getnPago());
                fPago.setText(pago.getFecha());
                impPago.setText(pago.getImporte());
            }
        });
        mViewModel.cargarPagos(getArguments());
    }

}