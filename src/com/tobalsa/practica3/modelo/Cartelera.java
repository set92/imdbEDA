package com.tobalsa.practica3.modelo;

import java.util.TreeMap;

public class Cartelera {
	private TreeMap<String, Pelicula> lista;
	private static Cartelera miCartelera = new Cartelera();
	
	private Cartelera() {
		lista = new TreeMap<String, Pelicula>();
	}
	
	public static Cartelera getCartelera() { return miCartelera; }
	
	public int obtenerNumPeliculas() { return this.lista.size(); }
	
	public  TreeMap<String, Pelicula> conversionLista() { return this.lista; }
	
	public boolean existePelicula(String titulo) { return this.lista.containsKey(titulo); }
	
	public Pelicula buscarPelicula(String titulo) { return this.lista.get(titulo); }
	
	public void insertarPelicula(Pelicula p) { lista.put(p.getTitulo(), p); }
	
	public void borrarPelicula(String titulo) { if(this.existePelicula(titulo)) lista.remove(titulo); }
}
