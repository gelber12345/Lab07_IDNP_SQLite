package com.idnp.lab07.Activitys.Cliente;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.idnp.lab07.Activitys.Adaptadores.ClienteAdapter;
import com.idnp.lab07.Activitys.Veterinarias.VeterinariasADD;
import com.idnp.lab07.R;
import com.idnp.lab07.model.DbCliente;
import com.idnp.lab07.model.entidades.Cliente;

import java.util.ArrayList;

public class MainCliente extends AppCompatActivity {
    RecyclerView rview;
    ArrayList<Cliente> listClientes = new ArrayList<>();
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cliente);
        rview = findViewById(R.id.listaClientes);
        rview.setLayoutManager(new LinearLayoutManager(this));

        DbCliente dbHelper = new DbCliente (this);

        ClienteAdapter clienteAdapter = new ClienteAdapter(dbHelper.mostrarClientes());

        rview.setAdapter(clienteAdapter);


        btnAdd = findViewById(R.id.btnMainClienteAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoAdd();
            }
        });
    }
    private void gotoAdd(){
        Intent intent = new Intent(this, ClienteAdd.class);
        startActivity(intent);
        this.finish();
    }
}