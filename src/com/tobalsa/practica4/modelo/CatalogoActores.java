package com.tobalsa.practica4.modelo;

public class CatalogoActores {
	private ListaActores lista;
	private static CatalogoActores miCatalogoActores = new CatalogoActores();

	private CatalogoActores() {
		lista = new ListaActores();
	}

	public static CatalogoActores getCatalogoActores() { return miCatalogoActores; }

	public ListaActores getLista() { return lista; }

	public void imprimirOrdenado() {
		ordenarCatalogo();
		this.lista.imprimir();
	}

	public void ordenarCatalogo() { quickSort(this.lista, 0, this.lista.obtenerNumActores() - 1); }

	private void quickSort(ListaActores lista, int inicio, int fin) {
		if(fin - inicio > 0) {
			int indice = particion(lista, inicio, fin);
			quickSort(lista, inicio, indice - 1);
			quickSort(lista, indice + 1, fin);
		}
	}

	private int particion(ListaActores lista, int i, int f) {
		Actor pivote = lista.obtenerPosicion(i);
		int izq = i;
		int der = f;

		while(izq < der) {
			while(lista.obtenerPosicion(izq).compareTo(pivote) <= 0 && izq < der) izq++;
			while(lista.obtenerPosicion(der).compareTo(pivote) > 0) der--;
			if(izq < der) swap(lista, izq, der);
		}
		lista.ponerPosicion(i, lista.obtenerPosicion(der));
		lista.ponerPosicion(der, pivote);
		return der;
	}

	private void swap(ListaActores lista, int one, int two) {
		Actor temp = lista.obtenerPosicion(one);
		lista.ponerPosicion(one, lista.obtenerPosicion(two));
		lista.ponerPosicion(two, temp);
	}

	public void imprimir() {	
		System.out.println("Hay un total de " + this.lista.obtenerNumActores() + " actores.");
		this.lista.imprimir();
	}
}
