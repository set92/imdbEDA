package com.tobalsa.practica2;

public class OrderedDoubleLinkedList<T extends Comparable<T>> extends DoubleLinkedList<T> implements OrderedListADT<T> {

	// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
    // TODO metodo incorrecto, corregir despues de preguntar, faltan los .prev
	public void add(T elem){
        Node<T> newLink = new Node<T>(elem);
        if (first == null) first = newLink;
        else if (elem.compareTo(first.data) == 0){// TODO no se si es comparar con 0 o con que, mirar doc
            newLink.next = first;
            first = newLink;
        }else {
            Node<T> anterior = first;
            Node<T> temp = first;
            while ((temp.next!=null) && (elem.compareTo(temp.data) == 1)){
                anterior = temp;
                temp = temp.next;
            }
            if (elem.compareTo(temp.data) == 1){
                anterior = temp;
            }
            newLink.next = anterior.next;
            anterior.next = newLink.next;
        }
	}

}
