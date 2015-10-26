package com.tobalsa.practica2;

public class OrderedDoubleLinkedList<T extends Comparable<T>> extends DoubleLinkedList<T> implements OrderedListADT<T> {

	// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
    // TODO metodo incorrecto, corregir despues de preguntar, faltan los .prev
	public void add(T elem){
        Node<T> nodoElem = new Node<T>(elem);
        if (first == null) {
            first = nodoElem;
            last = nodoElem;
        }else if (elem.compareTo(first.data) <= 0){// Si el elem es el menor
            nodoElem.next = first;
            first.prev = nodoElem;
            first = nodoElem;
        }else {//busqueda del nodo anterior al que se debe insertar
            Node<T> anterior = first;
            Node<T> temp = first;
            while ((temp.next != null) && (elem.compareTo(temp.data) >= 0)){
                anterior = temp;
                temp = temp.next;
            }
            if (elem.compareTo(temp.data) >= 0){//Se inserta detras del ultimo nodo
                anterior = temp;
            }
            nodoElem.next = anterior.next;
            nodoElem.prev = anterior.prev;
            anterior.next = nodoElem.next;
            anterior.prev = nodoElem.prev;
        }
	}

}
