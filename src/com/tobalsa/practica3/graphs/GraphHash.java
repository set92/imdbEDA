package com.tobalsa.practica3.graphs;

import com.tobalsa.practica3.modelo.CatalogoActores;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphHash {

	HashMap<String, ArrayList<String>> g;
	
	public void crearGrafo(CatalogoActores miCatalogoActores){
        g = new HashMap<String, ArrayList<String>>();
        String apellidoActor, tituloPelicula;
        for (int i = 0; i < miCatalogoActores.getLista().obtenerNumActores(); i++) {
            apellidoActor = miCatalogoActores.getLista().obtenerPosicion(i).getApellidos();
            g.put(apellidoActor, new ArrayList<String>());
            
            for (int j = 0; j < miCatalogoActores.getLista().obtenerPosicion(i).getApariciones().obtenerNumPeliculas(); j++) {
            	tituloPelicula = miCatalogoActores.getLista().obtenerPosicion(i).getApariciones().obtenerPosicion(j).getTitulo();
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
