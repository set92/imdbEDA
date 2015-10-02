package com.tobalsa.models;

import com.tobalsa.actores.ListaActores;

/**
 * Created by toburi on 30/09/2015.
 * Creado por toburi el 30/09/2015.
 */
public class Pelicula implements Comparable<Pelicula> {
    private String titulo;
    private ListaActores listaAct;
    private int recaudacion;

    public Pelicula(String titulo) {
        this.titulo = titulo;
        this.recaudacion = 0;
        this.listaAct = new ListaActores();
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public ListaActores getListaAct() {
        return listaAct;
    }
    public void setListaAct(ListaActores listaAct) {
        this.listaAct = listaAct;
    }
    public int getRecaudacion() {
        return recaudacion;
    }
    public void setRecaudacion(int recaudacion) {
        this.recaudacion = recaudacion;
    }

    public void imprimir(){
        System.out.println(this.getTitulo()+", sus actores son: "+this.);
        this.listaAct.imprimir();
    }

    @Override
    public int compareTo(Pelicula o) {
        return this.getTitulo().compareTo(o.getTitulo());
    }

}
