package com.company;

import sun.security.util.BitArray;

/**
 * An implementation of the BloomFilter algorithm.
 */
public class BloomFilter {
    private final int DEFAULT_SIZE = 32;
    private int size;
    private final BitArray bits;

    public BloomFilter() {
        this.size = DEFAULT_SIZE;
        this.bits = new BitArray(size);
    }

    public BloomFilter(int size) {
        if (size <= 0) {
            this.size = DEFAULT_SIZE;
        } else {
            if (Integer.bitCount(size) != 1) {
                throw new IllegalArgumentException("Consider size being the power of two");
            }
            this.size = size;
        }
        this.bits = new BitArray(size);
    }

    public int getFirstIndex(String value) {
        int index = value.hashCode() % size;
        return index >= 0 ? index : -index;
    }

    public int getSecondIndex(String value) {
        int index = ((2 * value.hashCode()) + 3) % 5;
        return index >= 0 ? index : -index;
    }

    public void add(String value) {
        int point1 = getFirstIndex(value);
        int point2 = getSecondIndex(value);
        bits.set(point1, true);
        bits.set(point2, true);
    }

    public boolean probablyContain(String value) {
        int point1 = getFirstIndex(value);
        int point2 = getSecondIndex(value);
        return bits.get(point1) && bits.get(point2);
    }

    public static void main(String[] args) {
        BloomFilter filter = new BloomFilter();
        filter.add("Valera");
        filter.add("Igor");

        System.out.println(filter.probablyContain("Valera"));
        System.out.println(filter.probablyContain("Igor"));
        System.out.println(filter.probablyContain("Serhii"));
    }

}
