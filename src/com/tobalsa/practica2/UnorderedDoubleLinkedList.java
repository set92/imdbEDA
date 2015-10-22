package com.tobalsa.practica2;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

	// a�ade un elemento al comienzo
	// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
	public void addToFront(T elem) {
        Node<T> newLink = new Node<T>(elem);
        newLink.next = first;

        if (first != null) first.prev = newLink;

        first = newLink;
	}

	// añade un elemento al final
	// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
	public void addToRear(T elem) {
        Node<T> newLink = new Node<T>(elem);
        newLink.prev = last;

        if (last != null) last.next = newLink;//al colocar un nuevo elemento tenemos qe linkarlo hacia atras y hacia delante

        last = newLink;
//lista vacia esta evaluada? TODO
    }

    // Añade elem detras de otro elemento concreto, target,  que ya se encuentra en la lista
    // COMPLETAR OPCIONAL!
	public void addAfter(T elem, T target) {
        Node<T> newLink = new Node<T>(elem);
        Node<T> targetLink = new Node<T>(target);//no me gusta crear nodo, no deberia estar ya creado?
        newLink.next = targetLink.next;
        if (targetLink.next != null) targetLink.next.prev = newLink;
        targetLink.next = newLink;
        newLink.prev = targetLink;
	}

}
