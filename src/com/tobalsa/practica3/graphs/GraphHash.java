package com.tobalsa.practica3.graphs;

import com.tobalsa.practica1.actores.ListaActores;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphHash {

	HashMap<String, ArrayList<String>> g;
	
	public void crearGrafo(ListaActores lActores){
        // Post: crea el grafo desde la lista de actores
        //       Los nodos son nombres de actores y títulos de películas

        // COMPLETAR CÓDIGO
    }

	public void print(){
		int i = 1;
		for (String s: g.keySet()){
			System.out.print("Element: " + i++ + " " + s + " --> ");
			for (String k: g.get(s)){
				System.out.print(k + " ### ");
			}
			System.out.println();
		}
	}
	
	public boolean estanConectados(String a1, String a2){
        // COMPLETAR CÓDIGO
        return false;
    }

}
