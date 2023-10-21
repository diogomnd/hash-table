package br.ufpb.dcx.datastructures.lists;

import br.ufpb.dcx.datastructures.exceptions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class of a Simple Linked List, where each Node stores data,
 * and points to the next one.
 *
 * @param <E> a generic type of object in the list
 */
public class LinkedList<E> implements List<E>, Iterable<E> {

    /**
     * Class that represents a node that contains data.
     *
     * @param <E> a generic type of object in the list
     */
    private static class Node<E> {
        private Node<E> next;
        private E element;

        public Node(E valor) {
            this.element = valor;
            this.next = null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the list");
            }
            E element = current.element;
            current = current.next;
            return element;
        }
    }

    private Node<E> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void add(E element) {
        if (head != null) {
            // Insertion when the list already has elements
            Node<E> aux = head;
            while (aux.next != null)
                aux = aux.next;
            aux.next = new Node<>(element);
        } else {
            // First insertion
            head = new Node<>(element);
        }
        size++;
    }

    /**
     * Returns the node of the given position.
     *
     * @param index the given position of the node
     * @return the node of the given position
     * @throws ListIndexOutOfBoundsException if the index is out of bounds
     */
    private Node<E> getNode(int index) {
        Node<E> aux = head;
        for (int i = 0; i < index; i++) {
            if (aux != null)
                aux = aux.next;
            else
                throw new ListIndexOutOfBoundsException("List index out of bounds");
        }
        return aux;
    }

    @Override
    public E get(int index) {
        Node<E> aux = getNode(index);
        if (aux != null)
            return aux.element;
        throw new ListIndexOutOfBoundsException("List index out of bounds");
    }

    @Override
    public void set(int index, E element) {
        Node<E> aux = getNode(index);
        if (aux != null)
            aux.element = element;
        else
            throw new ListIndexOutOfBoundsException("List index out of bounds");
    }

    @Override
    public int indexOf(E element) {
        int i = 0;
        for (E e : this) {
            if (e.equals(element))
                return i;
            i++;
        }
        return -1;
    }

    @Override
    public void insert(int index, E element) {
        Node<E> node = new Node<>(element);
        if (index == 0) {
            node.next = head;
            head = node;
        } else {
            Node<E> aux = getNode(index - 1);
            node.next = aux.next;
            aux.next = node;
        }
        size++;
    }

    @Override
    public boolean remove(E element) {
        if (isEmpty()) {
            throw new EmptyListException("List is empty");
        } else if (head.element.equals(element)) {
            head = head.next;
            size--;
            return true;
        } else {
            Node<E> predecessor = head;
            for (Node<E> aux = head.next; aux != null; aux = aux.next) {
                if (aux.element.equals(element)) {
                    predecessor.next = aux.next;
                    aux.next = null;
                    size--;
                    return true;
                }
                predecessor = aux;
            }
            return false;
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder builder = new StringBuilder();
        int i = 0;
        builder.append("[");
        for (E element : this) {
            if (i == size() - 1)
                builder.append(element);
            else
                builder.append(element).append(", ");
            i++;
        }
        builder.append("]");
        return builder.toString();
    }
}