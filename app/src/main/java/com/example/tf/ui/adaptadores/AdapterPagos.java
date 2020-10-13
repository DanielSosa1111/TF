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
import com.example.tf.entidades.Pago;


import java.util.List;

public class AdapterPagos extends RecyclerView.Adapter<AdapterPagos.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    List<Pago> model;
    private Context context;
    private View.OnClickListener listener;

    public AdapterPagos (Context context, List<Pago> model){
        this.inflater = LayoutInflater.from(context);
        this.model = model;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterPagos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.pago_item, parent, false);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){ this.listener = listener; }

    @Override
    public void onBindViewHolder(@NonNull AdapterPagos.ViewHolder holder, int position) {

        String dir = model.get(position).getDom();
        int imagen = model.get(position).getImagenIdPagos();

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
            dir = itemView.findViewById(R.id.etDireccionPagos);
            imagen = itemView.findViewById(R.id.ivPagos);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    Pago pagos = model.get(getAdapterPosition());
                    bundle.putSerializable("datosPagos", pagos);
                    Navigation.findNavController((Activity) context, R.id.nav_host_fragment).navigate(R.id.detallePagos, bundle);
                }
            });
        }
    }
}
