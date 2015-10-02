package com.tobalsa.models;

import com.tobalsa.peliculas.ListaPeliculas;

/**
 * Created by toburi on 30/09/2015.
 * Creado por toburi el 30/09/2015.
 */
public class Actor implements Comparable<Actor>{
    private String nombre;
    private ListaPeliculas listPeli;

    public Actor(String nombre) {
        this.nombre = nombre;
        this.listPeli = new ListaPeliculas();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ListaPeliculas getListPeli() {
        return listPeli;
    }
    public void setListPeli(ListaPeliculas listPeli) {
        this.listPeli = listPeli;
    }

    public void imprimir(){
        System.out.println(this.getNombre()+", sus PELICULAS son: "+this.);
        this.listPeli.imprimir();
    }

    @Override
    public int compareTo(Actor o) {
        return this.getNombre().compareTo(o.getNombre());
    }
}
