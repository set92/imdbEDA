package com.tobalsa.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by toburi on 08/10/2015.
 * Creado por toburi el 08/10/2015.
 */
public class PeliculaTest {
    Actor a1,a2,a3;
    Pelicula p1,p2,p3;

    @Before
    public void setUp() throws Exception {
        a1=new Actor("Wayne, Bruce");
        a2=new Actor("");
        p1=new Pelicula("Batman");
        p2=new Pelicula("Superman");
        p1.getListaA().anadirActor(a1);
    }

    @After
    public void tearDown() throws Exception {
        a1=null;
        a2=null;
        a3=null;
        p1=null;
        p2=null;
        p3=null;
    }


    @Test
    public void testImprimir() {
        p1.imprimir();
    }

    @Test
    public void testMostrarApariciones() {
        p1.mostrarApariciones();
        p1.getListaA().anadirActor(a2);
        p1.mostrarApariciones();
        p1.getListaA().eliminarActor(a2);
        p1.mostrarApariciones();
        p1.getListaA().anadirActor(a3);
        p2.mostrarApariciones();
    }

    @Test
    public void testIncrementarRecaudacion(){
        assertEquals(p1.getRecaudacion(),0);
        p1.incrementarR(1000);
        assertEquals(p1.getRecaudacion(),1000);
        p1.incrementarR(-100);
        assertEquals(p1.getRecaudacion(),900);
    }
}