package com.tobalsa.proyectos;

import com.tobalsa.actores.CatalogoActores;
import com.tobalsa.models.Actor;
import com.tobalsa.models.Pelicula;
import com.tobalsa.peliculas.CatalogoPeliculas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by toburi on 01/10/2015.
 * Creado por toburi el 01/10/2015.
 */
public class Fichero {

    public void cargarFichero(){//String path
        Pelicula objPeli;
        Actor objActor;
        CatalogoActores catActores = CatalogoActores.getCatalogoActores();
        CatalogoPeliculas catPelicula = CatalogoPeliculas.getCatalogoPeliculas();
        String[] a;
        HashMap<String, Pelicula> hm;

        int cont = 0;

        try {
            hm = new HashMap<String,Pelicula>();
            BufferedReader br = new BufferedReader(new FileReader("actors-movies-2015-2016.txt"));
            String line = br.readLine();
            while (line != null){
                a = line.split("\\s+###\\s+");//Por cada linea corta nombres y mete en posiciones del array
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
            //Actor a = CatalogoActores.getCatalogoActores().buscarActorPorNombre("Gugliemi, Noel");
            //a.mostrarApariciones();

            //CatalogoActores.getCatalogoActores().ordenarLista();

            //Pelicula p = CatalogoPeliculas.getCatalogoPeliculas().buscarPeliculaPorTitulo("Seven Mummies");
            //p.mostrarApariciones();

            System.out.println("done");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarFichero(){
        CatalogoActores catAct = CatalogoActores.getCatalogoActores();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("actors-movies-2015-2016.bak.txt"));
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

//    public void guardar(String ruta) {
//        CatalogoActores miCatalogoActores = CatalogoActores.getCatalogoActores();
//        int cont =0;
//
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
//
//            for (int i = 0; i < miCatalogoActores.obtenerLista().tamano(); i++) {
//                Actor a = miCatalogoActores.obtenerLista().obtenerActor(i);
//                String linea = a.getNombre();
//
//                for (int j = 0; j < a.getListaP().tamano(); j++) {
//                    Pelicula p = a.getListaP().getPelicula(j);
//                    linea += " ### " + p.getTitulo();
//                }
//
//                bw.write(linea);
//                bw.newLine();
//                bw.flush(); // Limpiar caché
//            }
//            bw.close();
//        } catch (IOException e) { e.printStackTrace();}
//    }
}
