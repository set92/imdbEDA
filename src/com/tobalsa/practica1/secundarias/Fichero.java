package com.tobalsa.practica1.secundarias;

import com.tobalsa.practica1.actores.CatalogoActores;
import com.tobalsa.practica1.models.Actor;
import com.tobalsa.practica1.models.Pelicula;
import com.tobalsa.practica1.peliculas.CatalogoPeliculas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Created by toburi on 01/10/2015.
 * Creado por toburi el 01/10/2015.
 */
public class Fichero {

    public void cargarFichero(String path){
        Pelicula objPeli;
        Actor objActor;
        CatalogoActores catActores = CatalogoActores.getCatalogoActores();
        String[] a;
        HashMap<String, Pelicula> hm;

        int cont = 0;

        try {
            hm = new HashMap<String,Pelicula>();
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            Pattern patron = Pattern.compile("\\s+###\\s+");
            while (line != null){
                a = patron.split(line);//Por cada linea corta nombres y mete en posiciones del array
                objActor = new Actor(a[0]);//Creamos objeto Actor con su nombre
                catActores.anadirActor(objActor);

                for (int i = 1; i < a.length; i++) {
                    objPeli = hm.get(a[i]);
                    if (objPeli == null){
                        objPeli = new Pelicula(a[i]);
                        hm.put(a[i], objPeli);
                    }
                    objPeli.anadirActor(objActor);
                    objActor.getListaP().anadirPelicula(objPeli);
                }
                cont++;
                line = br.readLine();//lectura siempre al final
                if(cont % 10000==0){System.out.println(cont);}//Imprime los numeros divisores de 10.000 para saber como va haciendolo
            }
            br.close();

            for (Pelicula p :hm.values()) {
                CatalogoPeliculas.getCatalogoPeliculas().anadirPelicula(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
    }

    public void guardarFichero(String path){
        CatalogoActores catAct = CatalogoActores.getCatalogoActores();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            Actor a;
            for (int i = 0; i < catAct.tamano(); i++) {
                a = CatalogoActores.getCatalogoActores().obtenerLista().obtenerActor(i);
                bw.write(a.getNombre());

                for (int j = 0; j < a.getListaP().tamano(); j++) {
                    bw.append(" ### ");
                    bw.write(a.getListaP().getPelicula(j).getTitulo());
                }
                bw.flush();
                bw.newLine();
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
