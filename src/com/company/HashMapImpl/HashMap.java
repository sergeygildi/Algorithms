package com.company.HashMapImpl;

/**
 * An implemented interface HashMap
 */
public interface HashMap<K, V> {
    V put(K k, V v);

    V get(K k);

    int size();

    interface Entry<K, V> {
        K getKey();

        V getValue();
    }

}
