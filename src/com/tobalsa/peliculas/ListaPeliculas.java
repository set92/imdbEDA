package com.tobalsa.peliculas;

import com.tobalsa.models.Pelicula;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by toburi on 30/09/2015.
 * Creado por toburi el 30/09/2015.
 */
public class ListaPeliculas {
	//atributos
	private ArrayList<Pelicula> listaP;

	//construcotra
	public ListaPeliculas() {
		this.listaP = new ArrayList<Pelicula>();
	}

	//metodos
	public int tamano(){
		return this.listaP.size();
	}
	public Pelicula getPelicula(int i){
		return this.listaP.get(i);
	}
	private Iterator<Pelicula> getIterador(){
		return this.listaP.iterator();
	}

	public Pelicula buscarPeliculaPorTitulo(String titulo){
		Pelicula seBusca = null;
		boolean enc = false;
		Iterator<Pelicula> itr = this.getIterador();
		while (!enc && itr.hasNext()){
			seBusca = itr.next();
			if (seBusca.getTitulo()==titulo){
				enc = true;
			}
		}
		if (!enc){
			seBusca=null;
		}
		return seBusca;
	}

	public boolean esta(Pelicula pPelicula){
		boolean esta = false;
		Pelicula unaPelicula = null;
		Iterator<Pelicula> itr = this.getIterador();
		while (!esta && itr.hasNext()){
			unaPelicula = itr.next();
			if (unaPelicula.getTitulo()==pPelicula.getTitulo()){
				esta = true;
			}
		}
		return esta;
	}

	public void anadirPelicula(Pelicula pPelicula){
			this.listaP.add(pPelicula);

	}
	public void eliminarPelicula(Pelicula pPelicula){
		if (this.esta(pPelicula)){
			this.listaP.remove(pPelicula);
		}
	}

//	public void ordenarListaPeliculas(){
//		ordenarQuickSort(0, this.tamano() - 1);
//	}
//
//	private void ordenarQuickSort(int pInicio, int pFin){
//		if (pFin - pInicio > 0){
//			int indexParticion = particion(pInicio,pFin);
//			this.ordenarQuickSort(pInicio, indexParticion - 1);
//			this.ordenarQuickSort(indexParticion + 1, pFin);
//		}
//	}
//
//	private int particion(int i, int f){
//		Pelicula actorPivote = this.listaP.get(i);
//		int izq = i;
//		int der = f;
//		while(izq<der){
//			while(this.listaP.get(izq).compareTo(actorPivote) <= 0 && izq < der) izq++;
//			if (izq<der)this.listaP.set(der,this.listaP.get(izq));
//			while(this.listaP.get(der).compareTo(actorPivote) > 0  && izq < der) der--;
//			if (izq<der)this.listaP.set(izq,this.listaP.get(der));
//
//		}
//		this.listaP.set(der, actorPivote);
//		return der;
//	}

	public void imprimir(){
		//TODO METODO ORDENAR NO FUNCIONA. FALTA DE HACER:
        //cargar a medias(falta pasar del hashmap a array), busqueda, ordenar, guardar
        //this.ordenarListaPeliculas();
		Pelicula unaPelicula = null;
		Iterator<Pelicula> itr = this.getIterador();
		while (itr.hasNext()){
			unaPelicula = itr.next();
			unaPelicula.imprimir();
		}
	}
}
