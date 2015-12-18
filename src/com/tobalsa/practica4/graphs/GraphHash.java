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
            a = actores.obtenerPosicion(i);//esta y la linea anterior te las quitas si haces forEach
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
    	int nPruebas = 100;
    	double g0, g1 = 0, E_ABS = 0.0001;
    	// g0 -> grado prueba anterior
    	// g1 -> grado prueba actual
    	do {
    		g0 = g1;
    		g1 = calcularGrado(nPruebas);
    		// System.out.println("Grado actual (" + nPruebas + " pruebas): " + g1 +	" (error actual: " + Math.abs(g0 - g1) + ")");
    		nPruebas += nPruebas;
		} while(Math.abs(g0 - g1) > E_ABS); // C�lculo del error absoluto
        return g1;
    }
    
    private double calcularGrado(int nPruebas) {
    	ListaActores lstAct = CatalogoActores.getCatalogoActores().getLista();
    	Random rnd = new Random();
    	String a1, a2;
    	double acum = 0;
        int numCamino = 0;
    	
    	for (int i = 0; i < nPruebas; i++) {
            a1 = lstAct.obtenerPosicion(rnd.nextInt(lstAct.obtenerNumActores())).devolverNombreCompleto();
            a2 = lstAct.obtenerPosicion(rnd.nextInt(lstAct.obtenerNumActores())).devolverNombreCompleto();
            ArrayList<String> temp = devolverCaminoConectado(a1, a2);

            if(temp.size() > 0){
                acum += temp.size() / 2;
                numCamino++;
            }
        }
    	return acum / numCamino;
    }
    
    public double centralidad(Actor a){
        
        return 0;

    }

    public ArrayList<Pareja> losDeMasCentralidad(int n){
        Random rnd = new Random();
        ListaActores lstAct = CatalogoActores.getCatalogoActores().getLista();
        HashMap<String, Integer> apariciones = new HashMap<String, Integer>();
        //Rellenar HashMap con actores
        for (int i = 0; i < lstAct.obtenerNumActores(); i++) {
            apariciones.put(lstAct.obtenerPosicion(i).devolverNombreCompleto(),0);
        }

        ArrayList<String> temp = new ArrayList<String>();
        String randomKey, randomKey2, nombre;
        for (int i = 0; i < 10; i++) {// TODO 10 tiene que ser el numero que aparezcan todos una vez
            randomKey = lstAct.obtenerPosicion( rnd.nextInt(lstAct.obtenerNumActores()) ).devolverNombreCompleto();
            randomKey2 = lstAct.obtenerPosicion( rnd.nextInt(lstAct.obtenerNumActores()) ).devolverNombreCompleto();


            temp = devolverCaminoConectado(randomKey,randomKey2);
            if (temp.size() > 0) {
                for (int j = 0; j < temp.size(); j++) {
                    nombre = temp.get(j);
                    if (apariciones.containsKey(nombre)) {
                        apariciones.put(nombre, apariciones.get(nombre) + 1);

                    }
                }
            }
        }
        //Para sacar los de mayores centralidad
        temp.clear();

        ArrayList<Pareja> arParejas = new ArrayList<Pareja>();
            for (HashMap.Entry<String, Integer> entry : apariciones.entrySet()) {
                arParejas.add(new Pareja(entry.getKey(), entry.getValue()));
            }
        Collections.sort(arParejas);

        if (arParejas.size() > n){
            ArrayList<Pareja> temp1 = new ArrayList<Pareja>();
            for (int i = arParejas.size(); i > arParejas.size() - n; i--) {
                temp1.add(arParejas.get(i-1));
            }
            return temp1;
        }

        else return arParejas;

    }

    private class Pareja implements Comparable<Pareja> {
        String nombre;
        Integer apariciones;

        public Pareja(String nombre, int apariciones) {
            this.nombre = nombre;
            this.apariciones = apariciones;
        }

        @Override
        public int compareTo(Pareja o) {
            return this.apariciones.compareTo(o.apariciones);
        }
    }
}

