package com.yq.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Objects;

public class MascotaFavorita extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotasFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_favorita);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Toolbar MascotasFavoritas = findViewById(R.id.miActionBar);
        setSupportActionBar(MascotasFavoritas);

        Bundle extras = this.getIntent().getExtras();
        mascotas = (ArrayList<Mascota>) extras.get("Mascotas");

        rvMascotasFavoritas = findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasFavoritas.setLayoutManager(llm);

        inicializarAdaptador();
    }
    public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas,this);
        rvMascotasFavoritas.setAdapter(adaptador);
    }
}