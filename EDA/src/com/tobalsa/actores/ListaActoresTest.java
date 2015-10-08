package com.tobalsa.actores;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tobalsa.models.Actor;
import com.tobalsa.models.Pelicula;

public class ListaActoresTest {
	ListaActores l1;
	Actor a1,a2,a3;
	Pelicula p1,p2,p3;

	@Before
	public void setUp()
	{
		lista1=new ListaLibros();	
		a1=new Actor("Wayne, Bruce");
        a2=new Actor("");
        p1=new Pelicula("Batman");
        p2=new Pelicula("Superman");
        a1.getListaP().anadirPelicula(p1);
	}

	@After
	public void tearDown()
	{
		lista1=null;
		l1=null;
		l2=null;
		l3=null;
        l4=null;
	}
	@Test
	public void testTamano() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarActorPorNombre() {
		fail("Not yet implemented");
	}

	@Test
	public void testEsta() {
		fail("Not yet implemented");
	}

	@Test
	public void testAnadirActor() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminarActor() {
		fail("Not yet implemented");
	}

	@Test
	public void testOrdenarListaActores() {
		fail("Not yet implemented");
	}

	@Test
	public void testImprimir() {
		fail("Not yet implemented");
	}

}
