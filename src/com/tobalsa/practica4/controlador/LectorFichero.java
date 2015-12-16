package com.tobalsa.practica4.controlador;

import com.tobalsa.practica4.graphs.GraphHash;
import com.tobalsa.practica4.modelo.*;

import java.io.*;
import java.util.Random;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class LectorFichero {
	public void cargar(String ruta) {
		CatalogoActores miCatalogoActores = CatalogoActores.getCatalogoActores();
		TreeMap<String, Pelicula> miCartelera = new TreeMap<String, Pelicula>();
		Actor a;
		Pelicula p;
		ListaPeliculas apariciones;
		String[] palabras, actor;
		String titulo;
		int cont = 0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			String linea = br.readLine();
			Pattern pat1 = Pattern.compile("\\s+([#]{3})\\s+");
			Pattern pat2 = Pattern.compile("[,]\\s+");

			while (linea != null) {
				palabras = pat1.split(linea);
				
				actor = pat2.split(palabras[0]);
				a = actor.length > 1 ? new Actor(actor[1], actor[0]) : new Actor(actor[0], "");
				miCatalogoActores.getLista().insertarActor(a);
				
				apariciones = new ListaPeliculas();
				
				for (int i = 1; i < palabras.length; i++) {
					titulo = palabras[i];
					p = miCartelera.get(titulo);
					if (p == null) {
						p = new Pelicula(titulo);
						miCartelera.put(p.getTitulo(), p);
					}
					apariciones.insertarPelicula(p);
					p.insertarReparto(a);
				}
				a.setApariciones(apariciones);
				
				cont++;
				if ((cont % 10000) == 0) System.out.println("He tratado " + cont + " actores.");
				linea = br.readLine();
			}
			br.close();

			for (Pelicula pelicula : miCartelera.values())
				CatalogoPeliculas.getCatalogoPeliculas().getLista().insertarPelicula(pelicula);

            GraphHash gh;

            gh = new GraphHash();
            gh.crearGrafo(miCatalogoActores);

            gh.gradoRelaciones();
            
		} catch (FileNotFoundException e) {
			System.out.println("El fichero seleccionado no existe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void guardar(String ruta) {
		CatalogoActores miCatalogoActores = CatalogoActores.getCatalogoActores();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));

			for (int i = 0; i < miCatalogoActores.getLista().obtenerNumActores(); i++) {
				Actor a = miCatalogoActores.getLista().obtenerPosicion(i);
				String linea = a.getApellidos() + ", " + a.getNombre();

				for (int j = 0; j < a.getApariciones().obtenerNumPeliculas(); j++) {
					Pelicula p = a.getApariciones().obtenerPosicion(j);
					linea += " ### " + p.getTitulo();
				}

				bw.write(linea);
				bw.newLine();
				bw.flush(); // Limpiar cache
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
