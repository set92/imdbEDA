package com.tobalsa.practica2.Implementaciones;

import com.tobalsa.practica2.Implementaciones.DoubleLinkedList;
import com.tobalsa.practica2.Interfaces.UnorderedListADT;
import com.tobalsa.practica2.Modelos.Node;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

	// Añade un elemento al comienzo
	public void addToFront(T elem) {
        Node<T> newLink = new Node<T>(elem);

        if (this.size()==0){
            last=newLink;
        }else {
            first.prev=newLink;
            newLink.next=first;
        }
        first=newLink;
        this.count++;
	}

	// Añade un elemento al final
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

    // Añade elem detras de otro elemento concreto, target,  que ya se encuentra en la lista
    // COMPLETAR OPCIONAL!
	public void addAfter(T elem, T target) {
        Node<T> newLink = new Node<T>(elem);
        Node<T> targetLink = first;
        boolean enc = false;
        int i = 1;
        if (first != null){
            while (!enc && i <= this.size()) {
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
    }

    public void comprobacionInversa(){
        Node<T> current = last;
        for (int i = this.size(); i>0; i--){
            System.out.println(current.data);
            current = current.prev;
        }
    }
}
