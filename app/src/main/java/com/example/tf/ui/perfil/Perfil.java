package com.example.tf.ui.perfil;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.tf.R;
import com.example.tf.ui.entidades.PerfilDatos;

public class Perfil extends Fragment {

    private com.example.tf.ui.perfil.PerfilViewModel vm;
    private EditText dni,apell,nom,tel,email,pass;
    private Button btnAceptar,btnEditar;

    public static Perfil newInstance() {
        return new Perfil();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View main= inflater.inflate(R.layout.perfil_fragment, container, false);

        // dni=(EditText)main.findViewById(R.id.etPerfilDni);
        // apell=(EditText)main.findViewById(R.id.etPerfilApellido);
        // nom=(EditText)main.findViewById(R.id.etPerfilNombre);
        // tel=(EditText)main.findViewById(R.id.etPerfilTelefono);
        // email=(EditText)main.findViewById(R.id.etPerfilEmail);
        // pass=(EditText)main.findViewById(R.id.etPerfilPass);

        // dni.getText();
        inicializar(main);


        //dni.setText("26329315");
        //apell.setText("SOSA");
        //nom.setText("Ricardo Daniel");
        //tel.setText("32323232");
        //email.setText("dani@fgfds");
        // pass.setText("4564dfss");

        return main;
    }

    //@Override
    // public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    //     super.onActivityCreated(savedInstanceState);
    //    mViewModel = ViewModelProviders.of(this).get(PerfilViewModel.class);

    //     // TODO: Use the ViewModel


    //pass.setText("111111");
    //  }

    private void inicializar(View view){

        dni=(EditText)view.findViewById(R.id.etPerfilDni);
        apell=(EditText)view.findViewById(R.id.etPerfilApellido);
        nom=(EditText)view.findViewById(R.id.etPerfilNombre);
        tel=(EditText)view.findViewById(R.id.etPerfilTelefono);
        email=(EditText)view.findViewById(R.id.etPerfilEmail);
        pass=(EditText)view.findViewById(R.id.etPerfilPass);

        btnEditar=view.findViewById(R.id.btnPerfilEditar);
        btnAceptar=view.findViewById(R.id.btnPerfilAceptar);

        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PerfilViewModel.class);
        vm.getPerfil().observe(getViewLifecycleOwner(), new Observer<PerfilDatos>() {
            @Override
            public void onChanged(PerfilDatos perfilDatos) {

                dni.setText(perfilDatos.getDni());
                apell.setText(perfilDatos.getApell());
                nom.setText(perfilDatos.getNom());
                tel.setText(perfilDatos.getTel());
                email.setText(perfilDatos.getEmail());
                pass.setText(perfilDatos.getPass());


            }
        });

        vm.obtenerPerfilD();

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dni.setEnabled(true);
                apell.setEnabled(true);
                nom.setEnabled(true);
                tel.setEnabled(true);
                email.setEnabled(true);
                pass.setEnabled(true);

                btnEditar.setVisibility(View.GONE);
                btnAceptar.setVisibility(View.VISIBLE);
            }
        });

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnEditar.setVisibility(View.VISIBLE);
                btnAceptar.setVisibility(View.GONE);

                dni.setEnabled(false);
                apell.setEnabled(false);
                nom.setEnabled(false);
                tel.setEnabled(false);
                email.setEnabled(false);
                pass.setEnabled(false);
            }
        });

    }
}