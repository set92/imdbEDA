package com.tobalsa.practica1.models;

import com.tobalsa.practica1.actores.ListaActores;
import com.tobalsa.practica2.DoubleLinkedList;

/**
 * Creado por Sergio & Peio el 30/09/2015.
 */
public class Pelicula implements Comparable<Pelicula> {
    //atributos
	private String titulo;
	private ListaActores listaA;
	private int recaudacion;
	//constructora
	public Pelicula(String titulo) {
		this.titulo = titulo;
		this.listaA = new ListaActores();
		this.recaudacion = 0;
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
    public void anadirActor(Actor pActor){this.listaA.anadirActor(pActor);}
    public void eliminarActor(Actor pActor){this.listaA.eliminarActor(pActor);}
    public void mostrarApariciones (){
        this.imprimir();
        System.out.println("Num actores: "+this.listaA.tamano());
        this.listaA.imprimir();
    }
	@Override
	public int compareTo(Pelicula o) {
		return this.getTitulo().compareTo(o.getTitulo());
	}
}
