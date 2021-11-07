package com.idnp.lab07.Activitys.Veterinarias;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.idnp.lab07.Activitys.Adaptadores.VeterinariasAdapter;
import com.idnp.lab07.R;
import com.idnp.lab07.model.DbHelper;
import com.idnp.lab07.model.DbVeterinarias;
import com.idnp.lab07.model.entidades.Veterinarias;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainVeterinarias extends AppCompatActivity {

    RecyclerView rview;
    ArrayList<Veterinarias> listVeterinarias = new ArrayList<>();
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_veterinarias);
        rview = findViewById(R.id.listaVeterinarias);
        rview.setLayoutManager(new LinearLayoutManager(this));

        DbVeterinarias dbHelper = new DbVeterinarias (this);

        VeterinariasAdapter veterinariasAdapter = new VeterinariasAdapter(dbHelper.mostrarVeterinarias());

        rview.setAdapter(veterinariasAdapter);


        btnAdd = findViewById(R.id.btnMainVeterinariasAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoAdd();
            }
        });
    }
    private void gotoAdd(){
        Intent intent = new Intent(this, VeterinariasADD.class);
        startActivity(intent);
        this.finish();
    }
}