package com.example.tf.ui.pagos;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tf.R;
import com.example.tf.ui.pagos.PagosViewModel;

public class Pagos extends Fragment {

    private com.example.tf.ui.pagos.PagosViewModel mViewModel;

    public static Pagos newInstance() {
        return new Pagos();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pagos_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PagosViewModel.class);
        // TODO: Use the ViewModel
    }

}