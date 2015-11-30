package com.tobalsa.practica4.modelo;

public class CatalogoPeliculas {
	private ListaPeliculas lista;
	private static CatalogoPeliculas miCatalogoPeliculas = new CatalogoPeliculas();
	
	private CatalogoPeliculas() {
		lista = new ListaPeliculas();
	}
	
	public static CatalogoPeliculas getCatalogoPeliculas() { return miCatalogoPeliculas; }
	
	public ListaPeliculas getLista() { return lista; }
	
	public void imprimir() {	
		System.out.println("Hay un total de " + this.lista.obtenerNumPeliculas() + " pel�culas.");
		this.lista.imprimir();
	}
}
