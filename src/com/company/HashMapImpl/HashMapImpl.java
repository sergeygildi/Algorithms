package com.company.HashMapImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of the HashMap.
 *
 * @param <K> – the type of keys maintained by this map
 * @param <V> – the type of mapped values
 */
public class HashMapImpl<K, V> implements HashMap<K, V> {
    private static int defaultLength = 16;
    private static double defaultLoader = 0.75;
    private Entry<K, V>[] entries;
    private int size = 0;

    @Override
    public V put(K k, V v) {
        if (size >= defaultLength * defaultLoader) {
            expand();
        }
        int index = getIndex(k);
        Entry<K, V> entry = this.entries[index];
        if (entry != null) {
            this.entries[index] = new Entry<>(k, v, entry);
        } else {
            this.entries[index] = new Entry<>(k, v, null);
            size++;
        }
        return this.entries[index].getValue();
    }

    private void expand() {
        Entry<K, V>[] newTable = new Entry[2 * defaultLength];
        rehash(newTable);
    }

    private void rehash(Entry<K, V>[] newTable) {
        List<Entry<K, V>> list = new ArrayList<>();

        for (Entry<K, V> entry : entries) {
            if (entry == null) {
                continue;
            }
            findEntryByNext(entry, list);
        }
        entries = newTable;
        if (!list.isEmpty()) {
            size = 0;
            defaultLength *= 2;

            for (Entry<K, V> entry : list) {
                if (entry.next != null) {
                    entry.next = null;
                }
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    private void findEntryByNext(Entry<K, V> entry, List<Entry<K, V>> list) {
        if (entry != null && entry.next != null) {
            list.add(entry);
            findEntryByNext(entry.next, list);
        } else {
            list.add(entry);
        }
    }

    @Override
    public V get(K k) {
        int index = getIndex(k);
        if (entries[index] == null) {
            return null;
        }
        return findValueByEqualKey(k, entries[index]);
    }

    private V findValueByEqualKey(K k, Entry<K, V> entry) {
        if (k == entry.getKey() || k.equals(entry.getKey())) {
            return entry.getValue();
        } else {
            if (entry.next != null) {
                return findValueByEqualKey(k, entry.next);
            }
        }
        return entry.getValue();
    }

    @Override
    public int size() {
        return this.size;
    }

    static class Entry<K, V> implements HashMap.Entry<K, V> {
        K k;
        V v;
        Entry<K, V> next;

        public Entry(K k, V v, Entry next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }

    public HashMapImpl(int length, double loader) {
        defaultLength = length;
        defaultLoader = loader;
        entries = new Entry[defaultLength];
    }

    public HashMapImpl() {
        this(defaultLength, defaultLoader);
    }

    private int getIndex(K k) {
        int m = defaultLength;
        int index = k.hashCode() % m;
        return index >= 0 ? index : -index;
    }

    public static void main(String[] args) {
        HashMapImpl<Integer, String> hashMap = new HashMapImpl<>();
        hashMap.put(10, "Apple");
        hashMap.put(1, "Orange");
        hashMap.put(79, "Grape");

        System.out.println("Size of Map: " + hashMap.size());

        System.out.println("Value at 79 " + hashMap.get(79));
        System.out.println("Value at 1 " + hashMap.get(1));
        System.out.println("Value at 10 " + hashMap.get(10));

        hashMap.put(10, null);
        System.out.println("Value at 10 " + hashMap.get(10));
    }

}
