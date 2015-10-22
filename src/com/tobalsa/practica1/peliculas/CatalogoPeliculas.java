package com.tobalsa.practica1.peliculas;

import com.tobalsa.practica1.models.Pelicula;

/**
 * Created by toburi on 01/10/2015.
 * Creado por toburi el 01/10/2015.
 */
public class CatalogoPeliculas {
	//atributos
	private ListaPeliculas lista;
	private static CatalogoPeliculas miCatalogoPeliculas = new CatalogoPeliculas();

	//constructora
	private CatalogoPeliculas(){
		this.lista = new ListaPeliculas();
	}

	//metodos
	public static CatalogoPeliculas getCatalogoPeliculas(){
		return miCatalogoPeliculas;
	}

	public int tamano(){
		return this.lista.tamano();
	}

	public Pelicula buscarPeliculaPorTitulo(String titulo){
		return this.lista.buscarPeliculaPorTitulo(titulo);
	}

	public void anadirPelicula(Pelicula pPelicula){
		this.lista.anadirPelicula(pPelicula);
	}

	public void eliminarPelicula(Pelicula pPelicula){
		this.lista.eliminarPelicula(pPelicula);
	}

	public void imprimirLista(){
		this.lista.imprimir();
	}
}
