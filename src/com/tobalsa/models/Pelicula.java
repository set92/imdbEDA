package com.tobalsa.models;

import com.tobalsa.actores.ListaActores;

/**
 * Creado por Sergio & Peio el 30/09/2015.
 */
public class Pelicula implements Comparable<Pelicula> {
    //atributos
	private String titulo;
	private ListaActores listaA;
	private int recaudacion;
	//constructora
	public Pelicula(String titulo, ListaActores listaA, int recaudacion) {
		super();
		this.titulo = titulo;
		this.listaA = listaA;
		this.recaudacion = recaudacion;
	}
	//getters y setters
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public ListaActores getListaA() {
		return listaA;
	}
	public void setListaA(ListaActores listaA) {
		this.listaA = listaA;
	}
	public int getRecaudacion() {
		return recaudacion;
	}
	public void setRecaudacion(int recaudacion) {
		this.recaudacion = recaudacion;
	}
	//metodos
	public void incrementarR(int n){
		this.recaudacion += n;
	}
	
	public void imprimir(){
		System.out.println(this.getTitulo());
	}

	@Override
	public int compareTo(Pelicula o) {
		return this.getTitulo().compareTo(o.getTitulo());
	}
}
