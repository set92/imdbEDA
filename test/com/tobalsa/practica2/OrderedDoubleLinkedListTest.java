package com.tobalsa.practica2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by toburi on 22/10/2015.
 * Creado por toburi el 22/10/2015.
 */
public class OrderedDoubleLinkedListTest {
	OrderedDoubleLinkedList<String> lista;
	
    @Before
    public void setUp() throws Exception {
    	lista = new OrderedDoubleLinkedList<String>();
    }

    @After
    public void tearDown() throws Exception {
    	lista = null;
    }
    
    @Test
    public void testAdd() throws Exception {
    	// TODO Imprimir resultados para comprobar el orden
    	lista.add("a");
    	
    	lista.remove("a");
    	
    	lista.add("b");
    	lista.add("a");
    	lista.add("b");
    	lista.add("c");
    	
    	lista.remove("a");
    	lista.remove("b");
    	lista.remove("c");
    	
    	lista.add("b");
    	lista.add("d");
    	lista.add("a");
    	lista.add("b");
    	lista.add("c");
    	lista.add("e");
    }
    
    @Test
    public void testRemoveFirst() throws Exception {
    	assertEquals(null, lista.removeFirst());
    	lista.add("x");
    	assertEquals("x", lista.removeFirst());
    	lista.add("x");
    	lista.add("y");
    	lista.add("z");
    	assertEquals("x", lista.removeFirst());
    }

    @Test
    public void testRemoveLast() throws Exception {
    	assertEquals(null, lista.removeLast());
    	lista.add("x");
    	assertEquals("x", lista.removeLast());
    	lista.add("x");
    	lista.add("y");
    	lista.add("z");
    	assertEquals("z", lista.removeLast());
    }

    @Test
    public void testRemove() throws Exception {
    	assertEquals(null, lista.remove("x"));
    	lista.add("x");
    	assertEquals("x", lista.remove("x"));
    	assertEquals(null, lista.remove("y"));
    	lista.add("x");
    	lista.add("y");
    	lista.add("z");
    	assertEquals("x", lista.remove("x"));
    	assertEquals("y", lista.remove("y"));
    	assertEquals("z", lista.remove("z"));
    	assertEquals(null, lista.remove("t"));
    }

    @Test
    public void testFirst() throws Exception {
    	assertEquals(null, lista.first());
    	lista.add("x");
    	assertEquals("x", lista.first());
    	lista.add("x");
    	lista.add("y");
    	lista.add("z");
    	assertEquals("x", lista.first());
    }

    @Test
    public void testLast() throws Exception {
    	assertEquals(null, lista.last());
    	lista.add("x");
    	assertEquals("x", lista.last());
    	lista.add("x");
    	lista.add("y");
    	lista.add("z");
    	assertEquals("z", lista.last());
    }

    @Test
    public void testContains() throws Exception {
    	assertFalse(lista.contains("x"));
    	lista.add("x");
    	assertTrue(lista.contains("x"));
    	assertFalse(lista.contains("y"));
    }

    @Test
    public void testFind() throws Exception {
    	assertEquals(null, lista.find("x"));
    	lista.add("x");
    	assertEquals("x", lista.find("x"));
    	assertEquals(null, lista.find("y"));
    	lista.add("x");
    	lista.add("y");
    	lista.add("z");
    	assertEquals("x", lista.find("x"));
    	assertEquals("y", lista.find("y"));
    	assertEquals("z", lista.find("z"));
    	assertEquals(null, lista.find("t"));
    }

    @Test
    public void testIsEmpty() throws Exception {
    	assertTrue(lista.isEmpty());
    	lista.add("x");
    	assertFalse(lista.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
    	assertEquals(0, lista.size());
    	lista.add("x");
    	assertEquals(1, lista.size());
    }
}