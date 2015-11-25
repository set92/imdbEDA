package com.tobalsa.practica3.graphs;

import com.tobalsa.practica1.actores.ListaActores;
import com.tobalsa.practica3.modelo.Actor;
import com.tobalsa.practica3.modelo.Pelicula;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	HashMap<String, Integer> th;
      String[] keys;
      ArrayList<Integer>[] adjList;
	
	public void crearGrafo(ListaActores lActores){
		// Post: crea el grafo desde la lista de actores
		//       Los nodos son nombres de actores y títulos de películas
		
		// Paso 1: llenar “th”
//        th = new HashMap<String, Integer>();
//        ArrayList<Actor> acts = lActores.susActores(); -> devuelve la lista de actores
//        int cont = 0;
//        for(Actor a : acts) {
//            th.put(a.getNombre(), cont);
//            cont++;
//            for(Pelicula p : getPelis()) {
//                if (th.containsKey(p.getTitulo())){
//                    th.put(p.getTitulo(), cont);
//                }
//            }
//        }

            // Paso 2: llenar “keys”
		keys = new String[th.size()];
		for (String k: th.keySet()) keys[th.get(k)] = k;

            // Paso 3: llenar “adjList”
            // COMPLETAR CÓDIGO
	}
	
	public void print(){
	   for (int i = 0; i < adjList.length; i++){
		System.out.print("Element: " + i + " " + keys[i] + " --> ");
		for (int k: adjList[i])  System.out.print(keys[k] + " ### ");
		
		System.out.println();
	   }
	}
	
	public boolean estanConectados(String a1, String a2){
		Queue<Integer> porExaminar = new LinkedList<Integer>();
		
		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		boolean enc = false;
		boolean[] examinados = new boolean[th.size()];

                 // COMPLETAR CÓDIGO
		
		return enc;

	}
}
