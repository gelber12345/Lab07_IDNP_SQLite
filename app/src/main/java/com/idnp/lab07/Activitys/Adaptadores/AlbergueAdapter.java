package com.idnp.lab07.Activitys.Adaptadores;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import com.idnp.lab07.Activitys.Albergues.AlbergueEdit;
import com.idnp.lab07.R;
import com.idnp.lab07.model.entidades.Albergue;

public class AlbergueAdapter extends RecyclerView.Adapter<AlbergueAdapter.AlbergueViewHolder>{

    ArrayList<Albergue> listaAlbergues;
    public AlbergueAdapter(ArrayList<Albergue> listaAlbergues) {
        this.listaAlbergues = listaAlbergues;
    }
    @NonNull
    @Override
    public AlbergueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_items_veterinarias, null, false);
        return new AlbergueAdapter.AlbergueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbergueViewHolder holder, int position) {
        holder.viewNombre.setText(listaAlbergues.get(position).getNombre());
        holder.viewDistrito.setText(listaAlbergues.get(position).getDistrito());
        holder.viewUbicacion.setText(listaAlbergues.get(position).getUbicacion());
        holder.viewCorreo.setText(listaAlbergues.get(position).getCorreo());
    }

    @Override
    public int getItemCount() {
        return listaAlbergues.size();
    }

    public class AlbergueViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombre, viewDistrito,viewUbicacion, viewCorreo;
        public AlbergueViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewDistrito = itemView.findViewById(R.id.viewDistrito);
            viewUbicacion = itemView.findViewById(R.id.viewUbicacion);
            viewCorreo = itemView.findViewById(R.id.viewCorreo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, AlbergueEdit.class);
                    intent.putExtra("ID", listaAlbergues.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
