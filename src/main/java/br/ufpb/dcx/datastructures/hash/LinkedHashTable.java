package br.ufpb.dcx.datastructures.hash;

import br.ufpb.dcx.datastructures.lists.*;

public class LinkedHashTable<K> implements HashTable<K> {
    private int capacity;
    private int size;
    private LinkedList<K>[] table;

    @SuppressWarnings("unchecked")
    public LinkedHashTable(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++)
            table[i] = new LinkedList<>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int hash(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    @Override
    public void put(K key) {
        int index = hash(key);
        table[index].add(key);
        size++;
    }

    @Override
    public boolean contains(K key) {
        int index = hash(key);
        for (K k : table[index])
            if (k.equals(key))
                return true;
        return false;
    }

    @Override
    public boolean remove(K key) {
        int index = hash(key);
        for (K k : table[index])
            if (k.equals(key)) {
                table[index].remove(k);
                return true;
            }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (LinkedList<K> l : table) {
            builder.append(i).append(" -> ");
            for (K key : l)
                builder.append(key).append(" -> ");
            builder.append("\\\n");
            i++;
        }
        return builder.toString();
    }

}