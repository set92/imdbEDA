package com.tobalsa.actores;

import com.tobalsa.secundarias.Fichero;
import com.tobalsa.secundarias.Stopwatch;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CatalogoActoresTest { // En esta clase está testeado el funcionamiento general del programa pedido para esta práctica
	Fichero lector;
	CatalogoActores miCatalogoActores;
	Stopwatch timer;
	
	@BeforeMethod
	public void setUp() throws Exception {
		lector = new Fichero();
		miCatalogoActores = CatalogoActores.getCatalogoActores();

	}

	@AfterMethod
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
