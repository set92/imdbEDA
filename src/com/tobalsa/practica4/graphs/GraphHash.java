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

    public double gradoRelaciones(int iteraciones){
        Random rnd = new Random();
        ListaActores lstAct = CatalogoActores.getCatalogoActores().getLista();
        String randomKey, randomKey2;
        double acum=0;

        for (int i = 0; i < iteraciones; i++) {
            randomKey = lstAct.obtenerPosicion( rnd.nextInt(lstAct.obtenerNumActores()) ).devolverNombreCompleto();
            randomKey2 = lstAct.obtenerPosicion( rnd.nextInt(lstAct.obtenerNumActores()) ).devolverNombreCompleto();

            if(estanConectados(randomKey, randomKey2 )){
                ArrayList<String> temp = devolverCaminoConectado(randomKey,randomKey2);
                acum += temp.size() / 2;
            }
        }
        return acum/iteraciones;
    }

    public double centralidad(Actor a){
        
        return 0;

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

}

