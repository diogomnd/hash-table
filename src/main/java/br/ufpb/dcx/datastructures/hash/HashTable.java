package br.ufpb.dcx.datastructures.hash;

/**
 * A generic Hash Table interface.
 *
 * @param <K> a generic type of object that represents the key
 */
public interface HashTable<K> {

    /**
     * Returns the number of elements in the hash table.
     *
     * @return the number of elements in the hash table
     */
    int size();

    /**
     * Returns a position in the vector calculated using
     * a hash  function based on the division method.
     *
     * @param key a key that will be converted to an integer
     *            by the hashCode() function
     * @return a valid position in the vector
     */
    int hash(K key);

    /**
     * Puts the element in the Hash table in the position calculated
     * by the hash function
     *
     * @param key the element that will be putted
     */
    void put(K key);

    /**
     * Returns true if the Hash table contains the key, false otherwise.
     *
     * @param key the key to search for
     * @return true if the table contains the key, false otherwise
     */
    boolean contains(K key);

    /**
     * Removes the given element. Returns true if the element was successfully
     * removed, and false if it was not found.
     *
     * @param key the element that will be removed
     * @return true if was removed, false if it was not found
     */
    boolean remove(K key);
}