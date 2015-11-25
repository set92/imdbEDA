package com.tobalsa.practica3.graphs;

import com.tobalsa.practica3.modelo.Actor;
import com.tobalsa.practica3.modelo.ListaActores;
import com.tobalsa.practica3.modelo.CatalogoActores;

import java.util.*;

public class GraphHash {
    HashMap<String, ArrayList<String>> g;

    public void crearGrafo(CatalogoActores miCatalogoActores) {
        g = new HashMap<String, ArrayList<String>>();

        ListaActores actores = miCatalogoActores.getLista();
        Actor a;
        String apellidoActor, tituloPelicula;

        for (int i = 0; i < actores.obtenerNumActores(); i++) {
            a = actores.obtenerPosicion(i);
            apellidoActor = a.devolverNombreCompleto();
            g.put(apellidoActor, new ArrayList<String>());

            for (int j = 0; j < a.getApariciones().obtenerNumPeliculas(); j++) {
                tituloPelicula = a.getApariciones().obtenerPosicion(j).getTitulo();
                if (!g.containsKey(tituloPelicula)){
                    g.put(tituloPelicula, new ArrayList<String>());
                }
                // Insertar apariciones
                ArrayList<String> apariciones = g.get(apellidoActor);
                apariciones.add(tituloPelicula);
                // Insertar reparto
                ArrayList<String> reparto = g.get(tituloPelicula);
                reparto.add(apellidoActor);
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
        else if(g.get(a1).contains(a2)) return true;
        else {
            String actual;
            Queue<String> porExaminar = new ArrayDeque<String>();
            porExaminar.add(a1);
            HashSet<String> examinados = new HashSet<String>();

            while(!hayCamino && !porExaminar.isEmpty()) {
                actual = porExaminar.poll();
                examinados.add(actual);
                if(actual.equals(a2)) hayCamino = true;
                else {
                    for (String x : g.get(actual)) {
                        if(!examinados.contains(x)) porExaminar.add(x);
                    }
                }
            }
        }
        return hayCamino;
    }

    public ArrayList<String> devolverCaminoConectado(String a1,String a2){
        boolean hayCamino = false;
        if(!g.containsKey(a1) || !g.containsKey(a2)) return null;
        else if(g.get(a1).contains(a2)) return null;
        else {
            String actual;
            Queue<String> porExaminar = new ArrayDeque<String>();
            porExaminar.add(a1);
            HashMap<String,String> examinados = new HashMap<String,String>();
            examinados.put(a1,null);

            while(!hayCamino && !porExaminar.isEmpty()) {
                actual = porExaminar.poll();

                if(actual.equals(a2)) hayCamino = true;
                else {
                    for (String x : g.get(actual)) {

                        if(!examinados.containsKey(x)) {
                            porExaminar.add(x);
                            examinados.put(x,actual);//TODO Preguntar koldo si es correcto, falta camino por recorrer
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public ArrayList<String> estanConectadosOpc(String a1, String a2){
        ArrayList<String> listaConectados = new ArrayList<String>();
        String fn = a2;

        boolean conectados = false;
        if(!g.containsKey(a1) || !g.containsKey(a2)) {} //mirad a ver si lo quereis cambiar, debe devolver null
        else if (a1.equals(a2)|| g.get(a1).contains(a2))
        {
            listaConectados.add(a1);
            listaConectados.add(a2);
        }
        else {
            HashSet<String> examinado = new HashSet<String>();
            Queue<String> porExaminar = new ArrayDeque<String>();
            HashMap<String,String> camino = new HashMap<String,String>(); //para poner la procedencia de los objetos
            porExaminar.add(a1);
            String act;
            ArrayList<String> lista;
            camino.put(a1, "-1"); //para que se pare el while del HashMap al encontrar a1
            while (!conectados && !porExaminar.isEmpty()){
                act = porExaminar.remove();
                examinado.add(act);
                if (act.equals(a2)) conectados = true;
                else{
                    lista = g.get(act);
                    for (int i=0; i<lista.size(); i++){
                        if (!examinado.contains(act)){
                            porExaminar.add(lista.get(i));
                            camino.put(lista.get(i),act); //por cada elemento se añade como objeto el elemento del que viene
                        }
                    }
                }
            }
            while(!camino.get(fn).equals("-1")){ //-1 es el objeto de a1
                listaConectados.add(camino.get(fn));
                fn = camino.get(fn); //para que en la siguiente vuelta la key 'fn' sea el actual objeto de 'fn'
            }
            //TODO queda recorrer la lista al revés para tener el camino de a1 a a2 y no de a2 a a1
        }
        return listaConectados;
    }
}

