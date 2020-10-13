package com.example.tf.ui.pagos;

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
import com.example.tf.entidades.Pago;
import com.example.tf.ui.adaptadores.AdapterPagos;

import java.util.List;

public class Pagos extends Fragment {

    private com.example.tf.ui.pagos.PagosViewModel mViewModel;
    private AdapterPagos adapterPagos;
    private RecyclerView recyclerView;
    private Context context;

    public static Pagos newIntance(){ return new Pagos(); }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.pago_rv, container, false);
        context = view.getContext();
        inicializar(view);
        return view;
    }

    public void inicializar(View view) {

        recyclerView = view.findViewById(R.id.pagosRv);
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PagosViewModel.class);

        mViewModel.getListMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Pago>>() {
            @Override
            public void onChanged(List<Pago> pagos) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                adapterPagos = new AdapterPagos(getContext(), pagos);
                recyclerView.setAdapter(adapterPagos);
            }
        });
        mViewModel.cargarLista();
    }

}