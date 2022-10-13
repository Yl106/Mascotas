package com.yq.mascotas;

import java.io.Serializable;
import java.util.Comparator;

public class Mascota implements Serializable {
    private int foto;
    private String nombre;
    private String identificacion;
    private String raza;
    private String nivel;
    private String pLike;

    public Mascota(int foto, String nombre, String pLike) {
        this.nombre = nombre;
        this.foto = foto;
        this.pLike = "0";
    }


    public Mascota(int foto, String nombre, String identificacion, String raza, String nivel, String pLike) {
        this.foto = foto;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.raza = raza;
        this.nivel = nivel;
        this.pLike = pLike;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getpLike() {
        return pLike;
    }

    public void setpLike(String pLike) {
        this.pLike = pLike;
    }
    public static Comparator<Mascota> getLike() { return MascotaL; }

    public static void setLike(Comparator<Mascota> MascotaL) { Mascota.MascotaL = MascotaL; }

    public static Comparator<Mascota> MascotaL = new Comparator<Mascota>() {
        @Override
        public int compare(Mascota l1, Mascota l2) {
            String Like1 = l1.getpLike();
            String Like2 = l2.getpLike();
            return Like2.compareTo(Like1);
        }
    };

    public static class MascotaAdaptador {
    }
}

