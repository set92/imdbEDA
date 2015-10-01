package com.tobalsa.actores;

import com.tobalsa.models.Actor;

import java.util.ArrayList;

/**
 * Created by toburi on 30/09/2015.
 * Creado por toburi el 30/09/2015.
 */
public class ListaActores <T extends Comparable<T>> extends ArrayList{
    private ArrayList<Actor> alLista;

    public ListaActores() {
        alLista = new ArrayList<Actor>();
    }

    public Actor buscarActorPorNombre(String nombre){
        mergeSort();
        //return Actor;
    }

    public void mergeSort(T[] alActores){
        ordenarLista(alActores, 0, alActores.length-1);
    }
//TODO mergesort
    private ListaActores ordenarLista(T[] tabla, int inicio, int fin){
        if ( inicio < fin ) { // hay más de un elemento en la tabla
            ordenarLista(tabla, inicio, (inicio+fin)/2);
            ordenarLista(tabla, ((inicio+fin)/2)+1, fin);
            merge(tabla, inicio, (inicio+fin)/2, fin);
        }
        ArrayList al = new ArrayList();
        al = tabla;
        return tabla;
    }

    private void merge (T[] tabla, int i, int centro, int f) {
        T[] arrayMerge = (T[]) (new Comparable[f - i + 1]);
        int izq = i;
        int der = centro + 1;
        int k = 0; //indice para rellenar laMezcla
        while (izq <= centro && der <= f) {
            if (tabla[izq].compareTo(tabla[der]) <= 0) {
                arrayMerge[k] = tabla[izq];
                k++;
                izq++;
            } else {
                arrayMerge[k] = tabla[der];
                k++;
                der++;
            }
        }
        if (izq > centro)
            while (der <= f) {
                arrayMerge[k] = tabla[der];
                k++;
                der++;
            }
        else {
            while (izq <= centro) {
                arrayMerge[k] = tabla[izq];
                k++;
                izq++;
            }
        }
        for (int j = i; j <= f; j++)
            tabla[j] = arrayMerge[j - i];
    }


}
