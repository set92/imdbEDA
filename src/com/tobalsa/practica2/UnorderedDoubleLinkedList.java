package com.tobalsa.practica2;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

	// A�ade un elemento al comienzo
	public void addToFront(T elem) {
        Node<T> newLink = new Node<T>(elem);
        newLink.next = first;

        if (first != null) {
            first.prev = newLink;
            newLink.prev = last;
        }
        this.count++;
        first = newLink;
	}

	// A�ade un elemento al final
	public void addToRear(T elem) {
        Node<T> newLink = new Node<T>(elem);

        if (this.size()==0){
            first = newLink;
        }else{
            last.next = newLink;
            newLink.prev = last;
        }
        last = newLink;
        this.count++;
    }

    // A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
    // COMPLETAR OPCIONAL!
	public void addAfter(T elem, T target) {
        Node<T> newLink = new Node<T>(elem);
        Node<T> targetLink = first;
        boolean enc = false;
        int i = 1;
        if (first != null){
            while (enc==false && i<=this.size()) {
                if (targetLink.data.equals(target)){
                    if (this.size()!=1 && i != this.size()) {
                        targetLink.next.prev = newLink;
                        newLink.next = targetLink.next;
                    }
                    else {
                        last = newLink;
                    }
                    newLink.prev = targetLink;
                    targetLink.next = newLink;
                    this.count++;
                    enc = true;
                }
                targetLink = targetLink.next;
                i++;
            }
        }
//        Node<T> newLink = new Node<T>(elem);
//        Node<T> targetLink = new Node<T>(target); //no me gusta crear nodo, no deber�a estar ya creado?
//        newLink.next = targetLink.next;
//        if (targetLink.next != null) targetLink.next.prev = newLink;
//        targetLink.next = newLink;
//        newLink.prev = targetLink;
//        this.count++;
    }

}
