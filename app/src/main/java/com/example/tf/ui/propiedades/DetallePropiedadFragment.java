package com.example.tf.ui.propiedades;

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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tf.R;
import com.example.tf.ui.entidades.Inmuebles;

public class DetallePropiedadFragment extends Fragment {

    DetallePropiedadViewModel detallePropiedadViewModel;
    private DetallePropiedadViewModel mViewModel;
    private EditText etDom, etAmb, etTipo, etUso, etPrecio;
    private CheckBox cbDisp;
    private Button btEditar;
    private ImageView ivImagenProp;

    public static DetallePropiedadFragment newInstance() {
        return new DetallePropiedadFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_detalle_propiedades, container, false);

        inicializar(view, savedInstanceState);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DetallePropiedadViewModel.class);
        // TODO: Use the ViewModel
    }

    public void inicializar(View view, Bundle bundle){

        ivImagenProp = view.findViewById(R.id.ivImagenProp);
        etDom = view.findViewById(R.id.etDomProp);
        etAmb = view.findViewById(R.id.etAmbProp);
        etTipo = view.findViewById(R.id.etTipoProp);
        etUso = view.findViewById(R.id.etUsoProp);
        etPrecio = view.findViewById(R.id.etPrecioProp);
        cbDisp = view.findViewById(R.id.cbDispProp);
        btEditar = view.findViewById(R.id.btEditDispProp);



        detallePropiedadViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(DetallePropiedadViewModel.class);
        detallePropiedadViewModel.getInmuebles().observe(getActivity(), new Observer<Inmuebles>() {
            @Override
            public void onChanged(Inmuebles inmuebles) {

                etDom.setText(inmuebles.getDomicilio());
                etAmb.setText(inmuebles.getAmbientes());
                etTipo.setText(inmuebles.getTipo());
                etUso.setText(inmuebles.getUso());
                etPrecio.setText(inmuebles.getPrecio());
                cbDisp.setChecked(inmuebles.isEstado());
                ivImagenProp.setImageResource(inmuebles.getImagenId());




            }
        });

         detallePropiedadViewModel.cargarInmueble(getArguments());
        // etDom.setText(inmuebles.getDomicilio());
    }

}