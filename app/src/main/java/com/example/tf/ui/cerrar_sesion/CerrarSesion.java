package com.example.tf.ui.cerrar_sesion;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tf.R;

public class CerrarSesion extends Fragment {

    private CerrarSesionViewModel mViewModel;

    public static CerrarSesion newInstance() {
        return new CerrarSesion();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cerrar_sesion_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CerrarSesionViewModel.class);
        // TODO: Use the ViewModel
    }

}