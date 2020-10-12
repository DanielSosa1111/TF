package com.example.tf.ui.contratos;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tf.R;
import com.example.tf.ui.contratos.ContratosViewModel;

public class Contratos extends Fragment {

    private com.example.tf.ui.contratos.ContratosViewModel mViewModel;

    public static Contratos newInstance() {
        return new Contratos();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contratos_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ContratosViewModel.class);
        // TODO: Use the ViewModel
    }
}