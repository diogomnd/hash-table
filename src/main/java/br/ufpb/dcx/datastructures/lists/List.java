package br.ufpb.dcx.datastructures.lists;

import br.ufpb.dcx.datastructures.exceptions.*;

/**
 * A generic list interface.
 *
 * @param <E> a generic type of object in the list
 */
public interface List<E> extends Iterable<E> {

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    int size();

    /**
     * Returns true if the list is empty, false otherwise.
     *
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Adds an element to the end of the list.
     *
     * @param element to be added to the end of the list
     */
    void add(E element);

    /**
     * Returns the element at the given position.
     *
     * @param index the position where the element is
     * @return the element at the given position
     * @throws ListIndexOutOfBoundsException if the index is out of bounds
     */
    E get(int index);

    /**
     * Replaces the element at the given position with the element
     * given as a parameter.
     *
     * @param index index of the element to replace
     * @param element element that replaces the previous one
     * @throws ListIndexOutOfBoundsException if the index is out of bounds
     */
    void set(int index, E element);

    /**
     * Returns the first occurrence of the element given as a parameter.
     * Returns -1 if the element has not been found.
     *
     * @param element the element to search for
     * @return the position of the first occurrence of the element, or -1
     * if the element has not been found.
     */
    int indexOf(E element);

    /**
     * Inserts an element at the given position.
     *
     * @param index the position that the element will be inserted
     * @param element the element that will be inserted at the given position
     */
    void insert(int index, E element);

    /**
     * Removes the first occurrence of the given element.
     * Returns true if the element was successfully removed,
     * and false if it was not found.
     *
     * @param element that will be removed
     * @return true if was removed, false if it was not found
     * @throws EmptyListException if the list is empty
     */
    boolean remove(E element);
}