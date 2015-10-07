package com.tobalsa.models;

import com.tobalsa.peliculas.ListaPeliculas;

/**
 * Creado por Sergio & Peio el 30/09/2015.
 */
public class Actor implements Comparable<Actor>{
	//atributos
	private String nombre;
	private ListaPeliculas listaP;
	//constructora
	public Actor(String nombre) {
		this.nombre = nombre;
		this.listaP = new ListaPeliculas();
	}
	//getters y setters
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ListaPeliculas getListaP() {
		return listaP;
	}
	public void setListaP(ListaPeliculas listaP) {
		this.listaP = listaP;
	}
	
	//metodos
	public void imprimir(){
        System.out.println(this.getNombre());
	}
	public void mostrarApariciones (){
		this.imprimir();
		System.out.println("Ha aparecido: "+this.listaP.tamano());
		this.listaP.imprimir();
	}

    @Override
    public int compareTo(Actor o) {
        return this.getNombre().compareTo(o.getNombre());
    }
}
