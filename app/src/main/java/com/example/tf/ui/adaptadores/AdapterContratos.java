package com.example.tf.ui.adaptadores;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tf.R;
import com.example.tf.entidades.Contrato;

import java.util.List;


public class AdapterContratos extends RecyclerView.Adapter<AdapterContratos.ViewHolder> implements View.OnClickListener{
    LayoutInflater inflater;
    List<Contrato> model;
    private Context context;
    private View.OnClickListener listener;

    public AdapterContratos(Context context, List<Contrato> model){

        this.inflater = LayoutInflater.from(context);
        this.model = model;
        this.context = context;
    }


    @NonNull
    @Override
    public AdapterContratos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.contratos_item, parent, false);
        //view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterContratos.ViewHolder holder, int position) {

        String dir = model.get(position).getDir();
        int imagen = model.get(position).getImagenIdCont();
        holder.dir.setText(dir);
        holder.imagen.setImageResource(imagen);

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View view) {

        if(listener!=null){
            listener.onClick(view);
        }

    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView dir;
        ImageView imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dir = itemView.findViewById(R.id.etDireccionContratos);
            imagen = itemView.findViewById(R.id.ivC);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    Contrato contratos = model.get(getAdapterPosition());
                    bundle.putSerializable("datosContrato", contratos);
                    Navigation.findNavController((Activity) context, R.id.nav_host_fragment).navigate(R.id.detalleContratos, bundle);
                }
            });

        }
    }
}
