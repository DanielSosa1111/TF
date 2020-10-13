package com.example.tf.ui.inquilinos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.example.tf.entidades.Inquilino;
import com.example.tf.R;

public class DetalleInquilino extends Fragment {

    private DetalleInquilinoViewModel detalleInquilinoViewModel;
    private Inquilino inquilino;
    private EditText etDireccion, etDni, etApellido, etNombre, etTelefono;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.detalle_inquilino, container, false);
        Log.d("salida", "pasando");
        inicializar (view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
    }

    public void inicializar(View view){

        etDni = view.findViewById(R.id.etInqDoc);
        etApellido = view.findViewById(R.id.etInqApellido);
        etNombre = view.findViewById(R.id.etInqNombre);
        etDireccion = view.findViewById(R.id.etInqDireccion);
        etTelefono = view.findViewById(R.id.etInqTelefono);



        detalleInquilinoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(DetalleInquilinoViewModel.class);
        detalleInquilinoViewModel.getInquilinos().observe(getActivity(), new Observer<Inquilino>() {
            @Override
            public void onChanged(Inquilino inquilinos) {

              etDni.setText(inquilinos.getDni());
              etApellido.setText(inquilinos.getApellido());
              etNombre.setText(inquilinos.getNombre());
              etDireccion.setText(inquilinos.getDireccion());
              etTelefono.setText(inquilinos.getTel());

            }
        });

        detalleInquilinoViewModel.cargarInquilino(getArguments());
        // etDom.setText(inmuebles.getDomicilio());
    }

}