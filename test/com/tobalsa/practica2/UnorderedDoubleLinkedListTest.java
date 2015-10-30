package com.tobalsa.practica2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by toburi on 22/10/2015.
 * Creado por toburi el 22/10/2015.
 */
public class UnorderedDoubleLinkedListTest {
	UnorderedDoubleLinkedList<String> lista;
	
    @Before
    public void setUp() throws Exception {
    	lista = new UnorderedDoubleLinkedList<String>();
    }

    @After
    public void tearDown() throws Exception {
    	lista = null;
    }

    @Test
    public void testAddToFront() throws Exception {
    	lista.addToFront("e");
    	lista.remove("e");
    	lista.addToFront("x");
    	lista.addToFront("e");
    	lista.remove("x");
    	lista.remove("e");
    	lista.addToFront("z");
    	lista.addToFront("y");
    	lista.addToFront("x");
		lista.comprobacionInversa();
    }

    @Test
    public void testAddToRear() throws Exception {
    	lista.addToRear("e");
        lista.remove("e");
    	lista.addToRear("x");
    	lista.addToRear("e");
    	lista.remove("x");
    	lista.remove("e");
    	lista.addToRear("x");
    	lista.addToRear("y");
    	lista.addToRear("z");
    	lista.addToRear("e");
		lista.comprobacionInversa();

    }

    @Test
    public void testAddAfter() throws Exception {
		lista.addAfter("e", "x");
    	lista.addToFront("x");
    	lista.addAfter("e", "x");
    	lista.addAfter("e", "y");
    	lista.remove("x");
    	lista.remove("e");
    	lista.addToRear("x");
    	lista.addToRear("y");
    	lista.addToRear("z");
    	lista.addAfter("e", "x");
    	lista.remove("e");
    	lista.addAfter("e", "y");
    	lista.remove("e");
    	lista.addAfter("e", "z");
    	lista.remove("e");
    	lista.addAfter("e", "t");
		lista.comprobacionInversa();
    }
}