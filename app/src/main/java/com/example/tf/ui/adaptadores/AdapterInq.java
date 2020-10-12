package com.example.tf.ui.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tf.R;
import com.example.tf.ui.entidades.Inquilino;

import java.util.List;

public class AdapterInq extends RecyclerView.Adapter<AdapterInq.ViewHolder> {

    private Context context;
    private List<Inquilino> inquilinos;
    private LayoutInflater inflater;

    public AdapterInq(Context context, List<Inquilino> inquilinos, LayoutInflater inflater){

        this.context = context;
        this.inquilinos = inquilinos;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_inquilinos_fragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.direccion.setText(inquilinos.get(position).getDireccion());
        holder.apellido.setText(inquilinos.get(position).getApellido());
        holder.ivImagen.setImageResource(inquilinos.get(position).getImagenIdInq());

    }

    @Override
    public int getItemCount() {
        return inquilinos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView apellido;
        TextView direccion;
        ImageView ivImagen;

        public ViewHolder (@NonNull View itemView){
            super(itemView);
            ivImagen = itemView.findViewById(R.id.ivImagenInq);
            direccion = itemView.findViewById(R.id.txDireccionInq);
            apellido = itemView.findViewById(R.id.txApellidoInq);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    Inquilino inquilino = inquilinos.get(getAdapterPosition());
                    bundle.putSerializable("inquilinos", inquilino);
                    //Navigation.findNavController((Activity) context,R.id.nav_host_fragment).navigate(R.id.listaInquilinos, bundle);

                }
            });
        }


    }
}
