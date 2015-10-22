package com.tobalsa.practica1.actores;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tobalsa.practica1.secundarias.Fichero;
import com.tobalsa.practica1.secundarias.Stopwatch;

public class CatalogoActoresTest { // En esta clase est� testeado el funcionamiento general del programa pedido para esta pr�ctica
	Fichero lector;
	CatalogoActores miCatalogoActores;
	Stopwatch timer;
	
	@Before
	public void setUp() throws Exception {
		lector = new Fichero();
		miCatalogoActores = CatalogoActores.getCatalogoActores();

	}

	@After
	public void tearDown() throws Exception { }
	
	@Test
	public void testCargarMostrarBuscarMostrarOrdenadoYGuardar() {

		timer = new Stopwatch();
		lector.cargarFichero("actors-movies-2015-2016.txt");
		System.out.println("\nFinalizado en " + timer.elapsedTime() + " ms. (carga)");

		timer = new Stopwatch();
		miCatalogoActores.imprimirLista();
		System.out.println("\nFinalizado en " + timer.elapsedTime() + " ms. (imprimir)");

		timer = new Stopwatch();
        miCatalogoActores.buscarActorPorNombre("  insd ttir, Hrefna");
        miCatalogoActores.buscarActorPorNombre("??ri, Esa");
        miCatalogoActores.buscarActorPorNombre("Iannuzzi, Mike (II)");
		System.out.println("\nFinalizado en " + timer.elapsedTime() + " ms. (busquedas)");

	}
}
