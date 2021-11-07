package com.idnp.lab07.Activitys.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.idnp.lab07.Activitys.Cliente.ClienteEdit;
import com.idnp.lab07.R;
import com.idnp.lab07.model.entidades.Cliente;


import java.util.ArrayList;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ClienteViewHolder>{

    ArrayList<Cliente> listaClientes;
    public ClienteAdapter(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;

    }
    @NonNull
    @Override
    public ClienteAdapter.ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_items_veterinarias, null, false);
        return new ClienteAdapter.ClienteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteAdapter.ClienteViewHolder holder, int position) {
        holder.viewCorreo.setText(listaClientes.get(position).getCorreo());
        holder.viewPassword.setText(listaClientes.get(position).getPassword());
        holder.viewUbicacion.setText(listaClientes.get(position).getUbicacion());

    }

    @Override
    public int getItemCount() {
        return listaClientes.size();
    }

    public class ClienteViewHolder extends RecyclerView.ViewHolder {
        TextView viewCorreo, viewPassword,viewUbicacion;
        public ClienteViewHolder(@NonNull View itemView) {
            super(itemView);

            viewCorreo = itemView.findViewById(R.id.viewNombre);
            viewPassword = itemView.findViewById(R.id.viewDistrito);
            viewUbicacion = itemView.findViewById(R.id.viewUbicacion);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, ClienteEdit.class);
                    intent.putExtra("ID", listaClientes.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
