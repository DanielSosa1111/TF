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
import com.example.tf.entidades.Inquilino;

import java.util.List;

public class AdapterInq extends RecyclerView.Adapter<AdapterInq.ViewHolder> implements View.OnClickListener{

    private Context context;
    private List<Inquilino> model;
    private LayoutInflater inflater;
    private View.OnClickListener listener;

    public AdapterInq(Context context, List<Inquilino> inquilinos, LayoutInflater inflater){

        this.context = context;
        this.model = inquilinos;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_inquilinos_fragment, parent, false);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String dir = model.get(position).getDireccion();
        String apell = model.get(position).getApellido();
        int imagen = model.get(position).getImagenIdInq();

        holder.dir.setText(dir);
        holder.apell.setText(apell);
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
    }}


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dir, apell;
        ImageView imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dir = itemView.findViewById(R.id.txDireccionInq);
            apell = itemView.findViewById(R.id.txApellidoInq);
            imagen = itemView.findViewById(R.id.ivImagenInq);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    Inquilino inquilinos = model.get(getAdapterPosition());

                    bundle.putSerializable("datosInq", inquilinos);
                    Navigation.findNavController((Activity) context, R.id.nav_host_fragment).navigate(R.id.detalleInquilinos, bundle);
                }
            });
        }
    }
}


