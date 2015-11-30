package com.tobalsa.practica4;

import com.tobalsa.practica4.controlador.LectorFichero;
import com.tobalsa.practica4.controlador.Stopwatch;
import com.tobalsa.practica4.modelo.CatalogoActores;

public class Principal {
	static CatalogoActores miCatalogoActores = CatalogoActores.getCatalogoActores();
	
	public static void main(String[] args) {
		double tiempo = Principal.iniciar("actors-movies-2015-2016.txt");
		System.out.println(tiempo);
	}
	
	public static double iniciar(String ruta) {
		Stopwatch timer = new Stopwatch();
		LectorFichero f = new LectorFichero();
		f.cargar(ruta);
		return timer.elapsedTime();
	}
	
	public static double mostrar() {
		Stopwatch timer = new Stopwatch();
		miCatalogoActores.imprimir();
		return timer.elapsedTime();
	}
	
	public static double buscar() {
		Stopwatch timer = new Stopwatch();
		miCatalogoActores.getLista().buscarActor("  rika");
		miCatalogoActores.getLista().buscarActor("Hector Kotsifakis");
		miCatalogoActores.getLista().buscarActor("��ri, Esa");
		return timer.elapsedTime();
	}
	
	public static double mostrarOrdenado() {
		Stopwatch timer = new Stopwatch();
		miCatalogoActores.imprimirOrdenado();
		return timer.elapsedTime();
	}
	
	public static double finalizar(String ruta) {
		Stopwatch timer = new Stopwatch();
		LectorFichero f = new LectorFichero();
		f.guardar(ruta);
		return timer.elapsedTime();
	}
}
