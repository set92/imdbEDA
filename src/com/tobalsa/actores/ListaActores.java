package com.tobalsa.actores;

import com.tobalsa.models.Actor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by toburi on 30/09/2015.
 * Creado por toburi el 30/09/2015.
 */
public class ListaActores {
    //atributos
    private ArrayList<Actor> listaA;

    //construcotra
    public ListaActores() {
        this.listaA = new ArrayList<Actor>();
    }

    //metodos
    public int tamano(){
        return this.listaA.size();
    }
    public Actor obtenerActor(int i){
        return this.listaA.get(i);
    }
    private Iterator<Actor> getIterador(){
        return this.listaA.iterator();
    }

    public Actor buscarActorPorNombre(String nombre){
        Actor seBusca = null;
        boolean enc = false;
        Iterator<Actor> itr = this.getIterador();
        while (!enc && itr.hasNext()){
            seBusca = itr.next();
            if (seBusca.getNombre().equals(nombre)){
                enc = true;
            }
        }
        if (!enc){
            seBusca=null;
        }
        return seBusca;
    }

    public boolean esta(Actor pActor){
        boolean esta = false;
        Actor unActor = null;
        Iterator<Actor> itr = this.getIterador();
        while (!esta && itr.hasNext()){
            unActor = itr.next();
            if (unActor.getNombre().equals(pActor.getNombre())){
                esta = true;
            }
        }
        return esta;
    }

    public void anadirActor(Actor pActor){
        this.listaA.add(pActor);
    }

    public void eliminarActor(Actor pActor){
        if (this.esta(pActor)){
            this.listaA.remove(pActor);
        }
    }

    public void ordenarListaActores(){
        ordenarQuickSort(0, this.tamano() - 1);
    }

    private void ordenarQuickSort(int pInicio, int pFin){
        if (pFin - pInicio > 0){
            int indexParticion = particion(pInicio,pFin);
            ordenarQuickSort(pInicio, indexParticion - 1);
            ordenarQuickSort(indexParticion + 1, pFin);
        }
    }

    private int particion(int i, int f){
        Actor actorPivote = listaA.get(i);
        int izq = i;
        int der = f;

        while(izq<der){
            while(listaA.get(izq).compareTo(actorPivote) <= 0 && izq < der) izq++;
            while(listaA.get(der).compareTo(actorPivote) > 0) der--;
            if (izq<der)swap(izq, der);

        }
        this.listaA.set(i, listaA.get(der));
        this.listaA.set(der, actorPivote);
        return der;
    }

    private void swap(int one, int two) {
        Actor temp = listaA.get(one);
        listaA.set(one, listaA.get(two));
        listaA.set(two, temp);
    }


    public void imprimir(){
        Iterator<Actor> itr = this.getIterador();
        while(itr.hasNext()) itr.next().imprimir();
    }
}
