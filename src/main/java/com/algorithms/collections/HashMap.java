package com.algorithms.collections;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * An implementation of the HashMap.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class HashMap<K, V> {
    private static final double DEFAULT_LOADER = 0.75;
    private static int defaultLength = 16;
    private Entry<K, V>[] entries;
    private int size;

    public void put(K k, V v) {
        if (size >= defaultLength * DEFAULT_LOADER) {
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

    public int size() {
        return this.size;
    }

    static class Entry<K, V> {
        private final K k;
        private final V v;
        private Entry<K, V> next;

        Entry(K k, V v, Entry next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public K getKey() {
            return k;
        }

        public V getValue() {
            return v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(k, entry.k);
        }

        @Override
        public int hashCode() {
            return Objects.hash(k);
        }
    }

    public HashMap() {
        entries = new Entry[defaultLength];
    }

    private int getIndex(K k) {
        int index = k.hashCode() % defaultLength;
        return index >= 0 ? index : -index;
    }

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(10, "Apple");
        hashMap.put(1, "Orange");
        hashMap.put(79, "Grape");

        PrintStream out = System.out;
        out.println("Size of Map: " + hashMap.size());

        out.println("Value at 79 " + hashMap.get(79));
        out.println("Value at 1 " + hashMap.get(1));
        out.println("Value at 10 " + hashMap.get(10));

        hashMap.put(10, null);
        out.println("Value at 10 " + hashMap.get(10));
    }

}
