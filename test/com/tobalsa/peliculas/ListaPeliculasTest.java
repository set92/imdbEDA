package com.tobalsa.peliculas;

import com.tobalsa.models.Pelicula;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ListaPeliculasTest {
	ListaPeliculas l1, l2;
	Pelicula p1, p2, p3;
	
	@Before
	public void setUp() throws Exception {
		p1 = new Pelicula("Batman");
		p2 = new Pelicula("Superman");
		l1 = new ListaPeliculas();
		l1.anadirPelicula(p1);
		l2 = new ListaPeliculas();
	}

	@After
	public void tearDown() throws Exception {
		l1 = null;
		l2 = null;
		p1 = null;
		p2 = null;
		p3 = null;
	}

	@Test
	public void testInsertarEliminarYObtenerNumPeliculas() {
		assertTrue(l1.tamano() == 1);
		l1.anadirPelicula(p2);
		assertTrue(l1.tamano() == 2);
		assertTrue(l2.tamano() == 0);
		l1.eliminarPelicula(p1);
		l1.eliminarPelicula(p2);
		assertTrue(l2.tamano() == 0);
	}


	@Test
	public void testExistePelicula() {
		assertTrue(l1.esta(p1));
		l1.anadirPelicula(p2);
		assertTrue(l1.esta(p2));
		l1.eliminarPelicula(p2);
		assertFalse(l1.esta(p2));
	}

	@Test
	public void testBuscarPelicula() {
		assertEquals(l1.buscarPeliculaPorTitulo(p1.getTitulo()), p1);
		l1.anadirPelicula(p2);
		assertEquals(l1.buscarPeliculaPorTitulo(p2.getTitulo()), p2);
		l1.eliminarPelicula(p2);
		assertNull(l1.buscarPeliculaPorTitulo(p2.getTitulo()));
	}
	
	@Test
	public void testImprimir() {
		l1.imprimir();
		l2.imprimir();
	}
}
