package com.example.tf.ui.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tf.R;
import com.example.tf.ui.entidades.Inmueble;

import java.util.List;

public class AdapterProp extends RecyclerView.Adapter<AdapterProp.ViewHolder> implements View.OnClickListener{

    LayoutInflater inflater;
    List<Inmueble> model;
    private Context context;

    private View.OnClickListener listener;

    public AdapterProp(Context context, List<Inmueble> model){

        this.inflater = LayoutInflater.from(context);
        this.model = model;
        this.context = context;



    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_propiedades, parent, false);
        //view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){

        this.listener = listener;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//aca
        String dir = model.get(position).getDomicilio();
        String cod = model.get(position).getCodigo();

        int imagen = model.get(position).getImagenId();
        Boolean checkbox = model.get(position).isEstado();

        holder.dir.setText(dir);
        holder.cod.setText(cod);
        holder.imagen.setImageResource(imagen);
        holder.checkBox.setChecked(checkbox);


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

        TextView dir, cod;
        ImageView imagen;
        CheckBox checkBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dir = itemView.findViewById(R.id.txDireccionProp);
            cod = itemView.findViewById(R.id.txCodigoProp);
            imagen = itemView.findViewById(R.id.ivProp1);
            checkBox = itemView.findViewById(R.id.cbListaPropDisp);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Bundle bundle = new Bundle();
                    Inmueble inmuebles = model.get(getAdapterPosition());
                    bundle.putSerializable("datosProp", inmuebles);
                    Navigation.findNavController((Activity) context, R.id.nav_host_fragment).navigate(R.id.detallePropiedades, bundle);

                }
            });

        }
    }

}
