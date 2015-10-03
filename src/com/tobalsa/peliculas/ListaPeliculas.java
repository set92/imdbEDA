package com.tobalsa.peliculas;

import com.tobalsa.models.Pelicula;

import java.util.ArrayList;

/**
 * Created by toburi on 30/09/2015.
 * Creado por toburi el 30/09/2015.
 */
public class ListaPeliculas extends ArrayList {
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
        if (!this.esta(pPelicula)){
            this.listaP.add(pPelicula);
        }
	}
	public void eliminarPelicula(Pelicula pPelicula){
        if (this.esta(pPelicula)){
            this.listaP.remove(pPelicula);
        }
	}
		
	public void ordenarListaPeliculas(){
		//TODO merge sort
	}
	
	public void imprimir(){
		this.ordenarListaPeliculas();
		Pelicula unaPelicula = null;
        Iterator<Pelicula> itr = this.getIterador();
        while (itr.hasNext()){
        	unaPelicula = itr.next();
        	unaPelicula.imprimir();
        }
	}
}
