package com.tobalsa.proyectos;

import com.tobalsa.actores.CatalogoActores;
import com.tobalsa.models.Actor;
import com.tobalsa.models.Pelicula;
import com.tobalsa.peliculas.CatalogoPeliculas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

        HashMap<String, Pelicula> hm;

        int cont = 0;

        try {
            hm = new HashMap<String,Pelicula>();
            BufferedReader br = new BufferedReader(new FileReader("actors-movies-2015-2016.txt"));
            String line = br.readLine();
            while (line != null){
                String[] a = line.split("\\s+###\\s+");//Por cada linea corta nombres y mete en posiciones del array
                objActor = new Actor(a[0]);//Creamos objeto Actor con su nombre
                catActores.anadirActor(objActor);

                for (int i = 1; i < a.length; i++) {
                    objPeli = hm.get(a[i]);
                    if (objPeli == null){
                        objPeli = new Pelicula(a[i]);
                        hm.put(a[i], objPeli);

                        //CatalogoPeliculas.getCatalogoPeliculas().anadirPelicula(objPeli);
                        //Hacerlo despues de tener todas las peliculas
                    }
                    objPeli.anadirActor(objActor);

                    objActor.getListaP().anadirPelicula(objPeli);
                }
                cont++;

                //catActores.anadirActor(objActor);//Añadir actor a catalogo
//                for (int i = 0; i < a.length; i++) {//Recorremos resto de linea y vamos agregando pelis al actor
//                    //TODO habra peliculas repetidas, o comprobar ahora o quitar redundantes luego
//                    //Si se hace con hashtable esta la solucion de que al ir por llaves, tu buscas con get una llave y listo, no puede haber duplicados
//                    objPeli = new Pelicula(a[i]);//Crear pelicula
//                    objActor.getListaP().anadirPelicula(objPeli);//Añadir peli a pelis de actor
//                    //catPelicula.anadirPelicula(objPeli);//Añadir peli al catalogo de actores
//                    objPeli.getListaA().anadirActor(objActor);//Añadir actor a su peli
//                }
                line = br.readLine();//lectura siempre al final
                if(cont % 10000==0){System.out.println(cont);}//Imprime los numeros divisores de 10.000 para saber como va haciendolo

            }
            br.close();
            Actor a = CatalogoActores.getCatalogoActores().buscarActorPorNombre("Gugliemi, Noel");
            a.mostrarApariciones();

            //Pelicula p = CatalogoPeliculas.getCatalogoPeliculas().buscarPeliculaPorTitulo("Seven Mummies");
            //p.mostrarApariciones();

            System.out.println("done");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
