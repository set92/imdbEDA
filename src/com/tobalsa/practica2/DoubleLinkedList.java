package com.tobalsa.practica2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

    // Atributos
    protected Node<T> first;
    protected Node<T> last; // apuntador al ultimo
    protected String descr;  // descripci�n
    protected int count;

    // Constructor
    public DoubleLinkedList() {
        first = null;
        last = null;
        descr = "";
        count = 0;
    }
    public void setDescr(String nom) {
        descr = nom;
    } // A�ade el nombre como descripci�n de la lista
    public String getDescr() {
        return descr;
    } // Devuelve la descripci�n de la lista

    // Elimina el primer elemento de la lista
    // Precondicion: la lista tiene al menos un elemento
    // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
    public T removeFirst() {
        if (isEmpty()) return null;
        else {
            T temp = first.data;
            first = first.next;
            this.count--;
            return temp;
        }

    }

    // Elimina el ultimo elemento de la lista
    // Precondicion: la lista tiene al menos un elemento
    // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
    public T removeLast() {
        if (isEmpty()) return null;
        else {
            T temp = last.data;

            if (size() > 1){
                last.prev.next = null;
                last = last.prev;
                this.count--;
            } else {
                first = first.next;
                this.count--;
            }
            return temp;
        }
    }

    public T remove(T elem) {
        Node<T> node = first;
        Node<T> temp;
        if (first != null) {
            if (node.data.equals(elem)) {
                if (this.size() == 1) {
                    last = null;
                }
                temp = first;
                first = temp.next;
                temp.prev = null;
                temp.next = null;
            } else {
                temp = node.prev;
                if (node == last) {
                    last = temp;
                }
                node.next = null;
                node.prev = null;
            }
            this.count--;
            return node.data;
        }else return null;
    }

    public T first() {
        //Da acceso al primer elemento de la lista
        if (isEmpty()) return null;
        else return first.data;
    }

    public T last() {
        //Da acceso al �ltimo elemento de la lista
        if (isEmpty()) return null;
        else return last.data;
    }

    // Determina si la lista contiene un elemento concreto
    public boolean contains(T elem) {
        if (isEmpty()) return false;

        Node<T> current = first; // Empieza con el primero elemento

        while ((current != null) && !elem.equals(current.data))
            current = current.next;
        if (current == null) return false;
        else return elem.equals(current.data);
    }

    //Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
    // COMPLETAR EL CODIGO Y CALCULAR EL COSTE
    public T find(T elem) {
        Node<T> current;
        for (current = first; current != null; current = current.next) {
            if (elem.equals(current.data)) return current.data;
        }
        return null;
    }

    public boolean isEmpty() {//Determina si la lista est� vac�a
        return last==null;
    }

    public int size() {//Determina el n�mero de elementos de la lista
        return count;
    }

    /**
     * Return an iterator to the stack that iterates through the items .
     */
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<T> {
        private Node<T> current = first;//Inicializamos

        @Override
        public boolean hasNext() { return current != null; }

        @Override
        public T next() {
            if (!hasNext())throw new NoSuchElementException();
            T item = current.data;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    } // private class

    public void visualizarNodos() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String result = new String();
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            T elem = it.next();
            result = result + elem.toString() + " ";
        }
        return result;
    }

}
