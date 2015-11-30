package com.tobalsa.practica4.modelo;

public class Actor implements Comparable<Actor> {
	private String nombre;
	private String apellidos;
	private ListaPeliculas apariciones;

	public Actor(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.apariciones = new ListaPeliculas();
	}

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getApellidos() { return apellidos; }
	public void setApellidos(String apellidos) { this.apellidos = apellidos; }

	public ListaPeliculas getApariciones() { return apariciones; }
	public void setApariciones(ListaPeliculas apariciones) { this.apariciones = apariciones; }

	public String devolverNombreCompleto() { return this.nombre + " " + this.apellidos; }
	
	public void insertarAparicion(Pelicula p) {
		if(p != null) apariciones.insertarPelicula(p);
	}
	
	public void mostrarApariciones() {
		this.imprimir();
		if(apariciones.obtenerNumPeliculas() > 0) {
			System.out.println("Ha aparecido en " + this.apariciones.obtenerNumPeliculas() + " pel�culas.");
			this.apariciones.imprimir();
		} else System.out.println("No ha aparecido en ninguna pel�cula");
	}
	
	public void imprimir() { System.out.println(this.devolverNombreCompleto()); }
	
	@Override
	public int compareTo(Actor a) {
		// compareTo devuelve < 0 si this es menor que el otro,
        // > 0 si this es mayor que el otro 
        // y 0 si ambos son equal
        int comparador = this.getApellidos().compareTo(a.getApellidos());
        return comparador == 0 ? this.getNombre().compareTo(a.getNombre()) : comparador;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Actor) {
			Actor a = (Actor) obj;
			if(this.devolverNombreCompleto().equals(a.devolverNombreCompleto())) return true;
			else return false;
		} else return false;
	}
}
