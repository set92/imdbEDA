package com.tobalsa.practica4.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaActores {
	private ArrayList<Actor> lista;
	
	public ListaActores() {
		this.lista = new ArrayList<Actor>();
	}
	
	public void insertarActor(Actor a) { lista.add(a); }
	
	public void borrarActor(String nombre) {
		Actor a = buscarActor(nombre);
		if(a != null) lista.remove(a);
		//else System.out.println("No existe una pel�cula con el t�tulo " +  nombre + ".");
	}
	
	public int obtenerNumActores() { return this.lista.size(); }
	
	public Actor obtenerPosicion(int i) { return this.lista.get(i); }
	
	public void ponerPosicion(int i, Actor a) { this.lista.set(i, a); }
	
	private Iterator<Actor> getIterador() { return this.lista.iterator(); }
	
	public boolean existeActor(String nombre) {
		Iterator<Actor> itr = this.getIterador();
		while(itr.hasNext()) {
			if(itr.next().devolverNombreCompleto().equals(nombre)) return true;
		}
		return false;
	}
	
	public Actor buscarActor(String nombre) {
		Actor a;
		Iterator<Actor> itr = this.getIterador();
		while(itr.hasNext()) {
			a = itr.next();
			if(a.devolverNombreCompleto().equals(nombre)) return a;
		}
		return null;
	}
	
	public void imprimir() {	
		Iterator<Actor> itr = this.getIterador();
		while(itr.hasNext()) itr.next().imprimir();
	}
}
