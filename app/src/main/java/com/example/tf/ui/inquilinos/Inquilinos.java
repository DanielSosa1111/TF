package com.example.tf.ui.inquilinos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tf.R;
import com.example.tf.ui.adaptadores.AdapterInq;
import com.example.tf.ui.entidades.Inquilino;

import java.util.List;

public class Inquilinos extends Fragment {

    private RecyclerView rvInq;
    private com.example.tf.ui.inquilinos.InquilinosViewModel inquilinosViewModel;
    AdapterInq adapter;
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.inquilinos_fragment, container, false);
        context = root.getContext();
        inicializar(root);
        return  root;
    }


    private void inicializar(View view){

        rvInq = view.findViewById(R.id.rvInquilinos);
        inquilinosViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinosViewModel.class);
        inquilinosViewModel.getInquilino().observe(getViewLifecycleOwner(), new Observer<List<Inquilino>>() {
            @Override
            public void onChanged(List<Inquilino> inquilinos) {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2, GridLayoutManager.VERTICAL, false);
                rvInq.setLayoutManager(gridLayoutManager);
                adapter = new AdapterInq(context, inquilinos, getLayoutInflater());
                rvInq.setAdapter(adapter);
            }
        });
        inquilinosViewModel.cargarInquilino();
    }
}