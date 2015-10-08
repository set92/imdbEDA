package com.tobalsa.actores;

import com.tobalsa.models.Actor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ListaActoresTest {
	ListaActores l1, l2;
	Actor a1, a2, a3;
	
	@Before
	public void setUp() throws Exception {
		a1 = new Actor("Carrey, Jim");
		a2 = new Actor("Cruise, Tom");
		l1 = new ListaActores();
		l1.anadirActor(a1);
		l2 = new ListaActores();
	}

	@After
	public void tearDown() throws Exception {
		l1 = null;
		l2 = null;
		a1 = null;
		a2 = null;
		a3 = null;
	}
	
	@Test
	public void testInsertarEliminarYObtenerNumActores() {
		assertTrue(l1.tamano() == 1);
		l1.anadirActor(a2);
		assertTrue(l1.tamano() == 2);
		assertTrue(l2.tamano() == 0);
		l1.eliminarActor(a1);
		l1.eliminarActor(a2);
		assertTrue(l2.tamano() == 0);
	}

	@Test
	public void testExisteActor() {
		assertTrue(l1.esta(a1));
		l1.anadirActor(a2);
		assertTrue(l1.esta(a2));
		l1.eliminarActor(a2);
		assertFalse(l1.esta(a2));
	}

	@Test
	public void testBuscarActor() {
		assertEquals(l1.buscarActorPorNombre(a1.getNombre()), a1);
		l1.anadirActor(a2);
		assertEquals(l1.buscarActorPorNombre(a2.getNombre()), a2);
		l1.eliminarActor(a2);
		assertNull(l1.buscarActorPorNombre(a2.getNombre()));
	}

	@Test
	public void testImprimir() {
		l1.imprimir();
		l2.imprimir();
	}

}
