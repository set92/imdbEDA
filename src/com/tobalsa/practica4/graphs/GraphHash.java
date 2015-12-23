package com.tobalsa.practica4.graphs;

import com.tobalsa.practica4.modelo.Actor;
import com.tobalsa.practica4.modelo.CatalogoActores;
import com.tobalsa.practica4.modelo.ListaActores;

import java.util.*;

public class GraphHash {
    HashMap<String, ArrayList<String>> g;

    public void crearGrafo(CatalogoActores miCatalogoActores) {
        g = new HashMap<String, ArrayList<String>>();
        ListaActores actores = miCatalogoActores.getLista();
        Actor a;
        String nombreActor, tituloPelicula;
        for (int i = 0; i < actores.obtenerNumActores(); i++) {
            a = actores.obtenerPosicion(i);
            nombreActor = a.devolverNombreCompleto();
            g.put(nombreActor, new ArrayList<String>());
            for (int j = 0; j < a.getApariciones().obtenerNumPeliculas(); j++) {
                tituloPelicula = a.getApariciones().obtenerPosicion(j).getTitulo();
                if (!g.containsKey(tituloPelicula)){
                    g.put(tituloPelicula, new ArrayList<String>());
                }
                // Insertar apariciones
                ArrayList<String> apariciones = g.get(nombreActor);
                apariciones.add(tituloPelicula);
                // Insertar reparto
                ArrayList<String> reparto = g.get(tituloPelicula);
                reparto.add(nombreActor);
            }
        }
    }

    public void print() {
        int i = 1;
        for (String s: g.keySet()){
            System.out.print("Element: " + i++ + " " + s + " --> ");
            for (String k: g.get(s)){
                System.out.print(k + " ### ");
            }
            System.out.println();
        }
    }

    public boolean estanConectados(String a1, String a2) {
        boolean hayCamino = false;
        if(!g.containsKey(a1) || !g.containsKey(a2)) return hayCamino;
        else {
            String actual;
            Queue<String> porExaminar = new LinkedList<String>();
            porExaminar.add(a1);
            HashSet<String> examinados = new HashSet<String>();
            examinados.add(a1);

            while(!hayCamino && !porExaminar.isEmpty()) {
                actual = porExaminar.poll();
                if(actual.equals(a2)) hayCamino = true;
                else {
                    for (String x : g.get(actual)) {
                        if(!examinados.contains(x)) {
                            porExaminar.add(x);
                            examinados.add(x);
                        }
                    }
                }
            }
        }
        return hayCamino;
    }
    
    public ArrayList<String> devolverCaminoConectado(String a1,String a2){
        boolean hayCamino = false;
        ArrayList<String> dev;

        if(!g.containsKey(a1) || !g.containsKey(a2)) return new ArrayList<String>();
        else {
            String actual;
            Queue<String> porExaminar = new LinkedList<String>();
            HashMap<String,String> examinados = new HashMap<String,String>();

            porExaminar.add(a1);
            examinados.put(a1,null);

            while(!hayCamino && !porExaminar.isEmpty()) {
                actual = porExaminar.poll();
                if(actual.equals(a2)) hayCamino = true;
                else {
                    for (String x : g.get(actual)) {
                        if(!examinados.containsKey(x)) {
                            porExaminar.add(x);
                            examinados.put(x,actual);
                        }
                    }
                }
            }
            dev = new ArrayList<String>();
            String actu2 = a2;//variable para no cargarse la de entrada
            while (actu2 != null){
                dev.add(actu2);
                actu2 = examinados.get(actu2);
            }
        }
        Collections.reverse(dev);
        return dev;
    }
    
    public double gradoRelaciones() {
    	int nPruebas = 250;
    	final double E_ABS = 0.0001;
    	double g0, g1 = 0;
    	// g0 -> grado prueba anterior
    	// g1 -> grado prueba actual
    	do {
    		g0 = g1;
    		g1 = calcularGrado(nPruebas);
    		System.out.println("Grado actual (" + nPruebas + " pruebas): " + g1 + " (error actual: " + Math.abs(g0 - g1) + ")");
    		nPruebas += nPruebas;
		} while(Math.abs(g0 - g1) > E_ABS); // Cálculo del error absoluto
        return g1;
    }
    
    private double calcularGrado(int nPruebas) {
    	ListaActores actores = CatalogoActores.getCatalogoActores().getLista();
    	Random rnd = new Random();
    	String a1, a2;
    	double acum = 0;
        int numCaminos = 0;
    	
    	for (int i = 0; i < nPruebas; i++) {
            a1 = actores.obtenerPosicion(rnd.nextInt(actores.obtenerNumActores())).devolverNombreCompleto();
            a2 = actores.obtenerPosicion(rnd.nextInt(actores.obtenerNumActores())).devolverNombreCompleto();
            
            ArrayList<String> temp = devolverCaminoConectado(a1, a2);
            if(temp.size() > 0) {
                acum += temp.size() / 2;
                numCaminos++;
            }
        }
    	return acum / numCaminos;
    }
    
    public ArrayList<Pareja> losDeMasCentralidad(int n){
        final int N_ITERACIONES = 427000;
    	Random rnd = new Random();
    	String a1, a2, nombre;
    	ListaActores actores = CatalogoActores.getCatalogoActores().getLista();
        HashMap<String, Integer> apariciones = new HashMap<String, Integer>();
        ArrayList<String> camino = new ArrayList<String>();
        //Rellenar HashMap con actores
        for (int i = 0; i < actores.obtenerNumActores(); i++) {
            apariciones.put(actores.obtenerPosicion(i).devolverNombreCompleto(),0);
        }
        for (int i = 0; i < N_ITERACIONES; i++) {
            a1 = actores.obtenerPosicion( rnd.nextInt(actores.obtenerNumActores()) ).devolverNombreCompleto();
            a2 = actores.obtenerPosicion( rnd.nextInt(actores.obtenerNumActores()) ).devolverNombreCompleto();
            camino = devolverCaminoConectado(a1, a2);
            if (camino.size() > 0) {
                for (int j = 0; j < camino.size(); j++) {
                    nombre = camino.get(j);
                    if (apariciones.containsKey(nombre)) 
                    	apariciones.put(nombre, apariciones.get(nombre) + 1);
                }
            }
        }
        ArrayList<Pareja> parejas = new ArrayList<Pareja>();
        for (HashMap.Entry<String, Integer> entry : apariciones.entrySet()) 
        	parejas.add(new Pareja(entry.getKey(), entry.getValue()));
        
        Collections.sort(parejas);
        if (parejas.size() > n) {
            ArrayList<Pareja> primerasParejas = new ArrayList<Pareja>();
            for (int i = parejas.size(); i > parejas.size() - n; i--) {
                primerasParejas.add(parejas.get(i - 1));
            }
            imprimirParejas(primerasParejas);
            return primerasParejas;
        } else{
        	imprimirParejas(parejas);
        	return parejas;
        }
    }
    
    public void imprimirParejas(ArrayList<Pareja> parejas) {
		for (Pareja pareja : parejas) {
			System.out.println(pareja.getNombre() + ", apariciones: " + pareja.getApariciones());
		}
	}
    
    public class Pareja implements Comparable<Pareja> {
        String nombre;
        Integer apariciones;

        public Pareja(String nombre, int apariciones) {
            this.nombre = nombre;
            this.apariciones = apariciones;
        }
        
        public String getNombre() { return nombre; }
		public void setNombre(String nombre) { this.nombre = nombre; }
		
		public Integer getApariciones() { return apariciones; }
		public void setApariciones(Integer apariciones) { this.apariciones = apariciones; }
		
		@Override
        public int compareTo(Pareja o) {
            return this.apariciones.compareTo(o.apariciones);
        }
    }
}

