package com.tobalsa.proyectos;

import com.tobalsa.actores.ListaActores;
import com.tobalsa.models.Actor;
import com.tobalsa.models.Pelicula;
import com.tobalsa.peliculas.ListaPeliculas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by toburi on 01/10/2015.
 * Creado por toburi el 01/10/2015.
 */
public class Fichero {
    public void cargarFichero(){//String path
        Pelicula objPeli;
        Actor objActor;
//TODO regex, separar en los distintos arrays // arraylist
        //TODO Hecho en principio, pero revisar, hay que usar los catalogos ahora y meter los actores en el?
        try {
            BufferedReader br = new BufferedReader(new FileReader("actors-small.txt"));
            String line = br.readLine();
            while (line != null){
                String[] a = line.split("\\s+###\\s+");//Por cada linea corta nombres y mete en posiciones del array
                objActor = new Actor(a[0], new ListaPeliculas());//Creamos objeto Actor con su nombre

                for (int i = 0; i < a.length; i++) {//Recorremos resto de linea y vamos agregando pelis al actor
                    objActor.getListaP().anadirPelicula(new Pelicula(a[i],new ListaActores(),0));
                }
                line = br.readLine();//lectura siempre al final
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
