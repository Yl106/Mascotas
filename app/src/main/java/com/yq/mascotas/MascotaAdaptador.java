package com.yq.mascotas;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }
    @NonNull
    @Override
    //Inflar el layout y lo pasará al viewholder para que obtenga los views
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvIdentificacionCV.setText(mascota.getIdentificacion());
        mascotaViewHolder.tvRazaCV.setText(mascota.getRaza());
        mascotaViewHolder.tvNivelCV.setText(mascota.getNivel());
        mascotaViewHolder.tvLike.setText(mascota.getpLike());

        mascotaViewHolder.imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Te gusta "+ mascota.getNombre(), Toast.LENGTH_SHORT) .show() ;
            }
        });
    }

    @Override
    public int getItemCount() { return mascotas.size();}

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        protected ImageView imgFoto;
        protected TextView tvNombreCV;
        protected TextView tvIdentificacionCV;
        protected TextView tvRazaCV;
        protected ImageView imgLike;
        protected TextView tvNivelCV;
        protected TextView tvLike;

        public MascotaViewHolder(View itemView){
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvNombreCV = itemView.findViewById(R.id.tvNombreCV);
            tvIdentificacionCV = itemView.findViewById(R.id.tvIdentificacionCV);
            tvRazaCV = itemView.findViewById(R.id.tvRazaCV);
            imgLike = itemView.findViewById(R.id.imgLike);
            tvNivelCV = itemView.findViewById(R.id.tvNivelCV);
            tvLike = itemView.findViewById(R.id.tvLikeCV);
        }
    }
}
