package com.tobalsa.practica2;

public class OrderedDoubleLinkedList<T extends Comparable<T>> extends DoubleLinkedList<T> implements OrderedListADT<T> {

	// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
    // TODO metodo incorrecto, corregir despues de preguntar, faltan los .prev
	public void add(T elem){
        Node<T> nodoElem = new Node<T>(elem);
        if (first == null) {
            first = nodoElem;
            last = nodoElem;
        }else if (elem.compareTo(first.data) <= 0){// Si elem es el menor
            nodoElem.prev = null;
            nodoElem.next = first;
            first.prev = nodoElem;
            first = nodoElem;
        } else if (elem.compareTo(last.data) >= 0) { //Si elem es mayor
            nodoElem.prev = last;
            nodoElem.next = null;
            last.next = nodoElem;
            last = nodoElem;
        } else {//busqueda del nodo anterior al que se debe insertar
            Node<T> current = first;
            while ((elem.compareTo(current.data) > 0)){
                current = current.next;
            }
            nodoElem.next = current;
            nodoElem.prev = current.prev;
            current.prev.next = nodoElem;
            current.prev = nodoElem;
        }
        this.count++;
	}



}
