package com.idnp.lab07.Activitys.Albergues;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.idnp.lab07.Activitys.Adaptadores.AlbergueAdapter;

import com.idnp.lab07.R;
import com.idnp.lab07.model.DbAlbergue;
import com.idnp.lab07.model.entidades.Albergue;

import java.util.ArrayList;

public class MainAlbergue extends AppCompatActivity {

    RecyclerView rview;
    ArrayList<Albergue> listAlbergues = new ArrayList<>();
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_albergue);
        rview = findViewById(R.id.listaAlbergues);
        rview.setLayoutManager(new LinearLayoutManager(this));

        DbAlbergue dbHelper = new DbAlbergue (this);

        AlbergueAdapter albergueAdapter = new AlbergueAdapter(dbHelper.mostrarAlbergues());

        rview.setAdapter(albergueAdapter);


        btnAdd = findViewById(R.id.btnMainAlbergueAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoAdd();
            }
        });
    }
    private void gotoAdd(){
        Intent intent = new Intent(this, AlbergueAdd.class);
        startActivity(intent);
        this.finish();
    }
}