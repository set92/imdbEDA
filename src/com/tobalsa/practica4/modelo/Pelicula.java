package com.tobalsa.practica4.modelo;

public class Pelicula implements Comparable<Pelicula> {
	private String titulo;
	private double recaudacion;
	private ListaActores reparto;

	public Pelicula(String titulo) {
		super();
		this.titulo = titulo;
		this.recaudacion = 0;
		this.reparto = new ListaActores();
	}

	public String getTitulo() { return titulo; }
	public void setTitulo(String titulo) { this.titulo = titulo; }

	public ListaActores getReparto() { return reparto; }

	public double getRecaudacion() { return recaudacion; }
	
	public void incrementarRecaudacion(double incremento) { this.recaudacion += incremento; }
	
	public void insertarReparto(Actor a) {
		if(a != null) reparto.insertarActor(a);
	}
	
	public void mostrarReparto() {
		this.imprimir();
		System.out.println("Tiene " + this.reparto.obtenerNumActores() + " actores en reparto.");
		this.reparto.imprimir();
	}
	
	public void imprimir() {
		System.out.println(this.getTitulo());
	}

	@Override
	public int compareTo(Pelicula p) {
		return this.getTitulo().compareTo(p.getTitulo());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pelicula) {
			Pelicula p = (Pelicula) obj;
			if(this.getTitulo().equals(p.getTitulo())) return true;
			else return false;
		} else return false;
	}
}
