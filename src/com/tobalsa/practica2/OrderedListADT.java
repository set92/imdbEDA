package com.tobalsa.practica2;

public interface OrderedListADT<T extends Comparable<T>>  extends ListADT<T>{
	
	public void add(T elem);
	// A�ade un elemento a la lista (en el lugar de orden que le corresponde)

}
