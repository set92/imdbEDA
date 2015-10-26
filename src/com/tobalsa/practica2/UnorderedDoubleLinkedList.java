package com.tobalsa.practica2;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

	// Añade un elemento al comienzo
	public void addToFront(T elem) {
        Node<T> newLink = new Node<T>(elem);
        newLink.next = first;
        
        if (first != null) first.prev = newLink;
        
        first = newLink;
	}

	// Añade un elemento al final
	public void addToRear(T elem) {
        Node<T> newLink = new Node<T>(elem);
        newLink.prev = last;

        if (last != null) last.next = newLink; // Al colocar un nuevo elemento tenemos que linkarlo hacia atrás y hacia delante

        last = newLink;
        //lista vacía esta evaluada? TODO
    }

    // Añade elem detrás de otro elemento concreto, target,  que ya se encuentra en la lista
    // COMPLETAR OPCIONAL!
	public void addAfter(T elem, T target) {
        Node<T> newLink = new Node<T>(elem);
        Node<T> targetLink = new Node<T>(target); //no me gusta crear nodo, no debería estar ya creado?
        newLink.next = targetLink.next;
        if (targetLink.next != null) targetLink.next.prev = newLink;
        targetLink.next = newLink;
        newLink.prev = targetLink;
	}

}
