package com.tobalsa.practica3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaPeliculas {
	private ArrayList<Pelicula> lista;
	
	public ListaPeliculas() {
		this.lista = new ArrayList<Pelicula>();
	}
	
	public void insertarPelicula(Pelicula p) { lista.add(p); }
	
	public void borrarPelicula(String titulo) {
		Pelicula p = buscarPelicula(titulo);
		if(p != null) lista.remove(p);
		//else System.out.println("No existe una pel�cula con el t�tulo " +  titulo + ".");
	}
	
	public int obtenerNumPeliculas() { return this.lista.size(); }
	
	public Pelicula obtenerPosicion(int i) { return this.lista.get(i); }
	
	private Iterator<Pelicula> getIterador() { return this.lista.iterator(); }
	
	public boolean existePelicula(String titulo) {
		Iterator<Pelicula> itr = this.getIterador();
		while(itr.hasNext()) {
			if(itr.next().getTitulo().equals(titulo)) return true;
		}
		return false;
	}
	
	public Pelicula buscarPelicula(String titulo) {
		Pelicula p;
		Iterator<Pelicula> itr = this.getIterador();
		while(itr.hasNext()) {
			p = itr.next();
			if(p.getTitulo().equals(titulo)) return p;
		}
		return null;
	}
	
	public void imprimir() {	
		Iterator<Pelicula> itr = this.getIterador();
		while(itr.hasNext()) itr.next().imprimir();
	}
}