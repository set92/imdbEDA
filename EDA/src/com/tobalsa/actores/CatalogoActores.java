package com.tobalsa.actores;

import com.tobalsa.models.Actor;

/**
 * Created by toburi on 01/10/2015.
 * Creado por toburi el 01/10/2015.
 */
public class CatalogoActores {
    //atributos
    private ListaActores lista;
    private static CatalogoActores miCatalogoActores = new CatalogoActores();

    //constructora
    private CatalogoActores(){
        this.lista = new ListaActores();
    }

    //metodos
    public static CatalogoActores getCatalogoActores(){
        return miCatalogoActores;
    }

    public int tamano(){
        return this.lista.tamano();
    }

    public Actor buscarActorPorNombre(String nombre){
        return this.lista.buscarActorPorNombre(nombre);
    }

    public void anadirActor(Actor pActor){
        this.lista.anadirActor(pActor);
    }

    public void eliminarActor(Actor pActor){
        this.lista.eliminarActor(pActor);
    }

    public void imprimirLista(){
        this.lista.imprimir();
    }

}
