package com.yq.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        Objects.requireNonNull(getSupportActionBar()).setLogo(R.mipmap.ic_huella);

        listaMascotas = findViewById(R.id.rvMascotas);
        //Lista
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        if (item.getItemId() == R.id.MascotasFavoritas) {
            Collections.sort(mascotas, Mascota.MascotaL);

            Intent i = new Intent(this, MascotaFavorita.class);
            i.putExtra("Mascotas", mascotas);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    //Adaptador
    public MascotaAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.mipmap.ic_bernardo, "Nombre: Romeo", "ID: 7894561", "Raza: San Bernardo", "Nivel:10","4"));
        mascotas.add(new Mascota(R.mipmap.ic_husky,"Nombre: Cookie", "ID: 1245697", "Raza: Husky", "Nivel: 5","7"));
        mascotas.add(new Mascota(R.mipmap.ic_yorkshire,"Nombre: Luna", "ID: 4561023", "Raza: Yorkshire", "Nivel: 9","3"));
        mascotas.add(new Mascota(R.mipmap.ic_caniche,"Nombre: Motas", "ID: 0112546", "Raza: Caniche", "Nivel: 4","2"));
        mascotas.add(new Mascota(R.mipmap.ic_bulldogg,"Nombre: Caballero", "ID: 9631245", "Raza: Bulldog", "Nivel: 5","1"));
    }
}
