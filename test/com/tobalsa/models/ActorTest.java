package com.tobalsa.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ActorTest {
	
	Actor a1,a2,a3;
	Pelicula p1,p2,p3;
	
	@Before
	public void setUp(){
		a1=new Actor("Wayne, Bruce");
        a2=new Actor("");
        p1=new Pelicula("Batman");
        p2=new Pelicula("Superman");
        a1.getListaP().anadirPelicula(p1);
	}

	@After
	public void tearDown(){
		a1=null;
        a2=null;
        a3=null;
        p1=null;
        p2=null;
        p3=null;
	}

	@Test
	public void testImprimir() {
		a1.imprimir();
	}

	@Test
	public void testMostrarApariciones() {
		a1.mostrarApariciones();
		a1.getListaP().anadirPelicula(p2);
		a1.mostrarApariciones();
		a1.getListaP().eliminarPelicula(p2);
		a1.mostrarApariciones();
		a1.getListaP().anadirPelicula(p3);
		a2.mostrarApariciones();		
	}

}
