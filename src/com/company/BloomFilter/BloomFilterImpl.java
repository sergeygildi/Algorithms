package com.company.BloomFilter;

import sun.security.util.BitArray;

/**
 * An implementation of the BloomFilter algorithm.
 */
public class BloomFilterImpl implements BloomFilter {
    private final int size;
    public static final int DEFAULT_SIZE = 32;
    private final BitArray bits;

    public BloomFilterImpl() {
        size = DEFAULT_SIZE;
        this.bits = new BitArray(size);
    }

    public BloomFilterImpl(int size) {
        if (size <= 0) {
            this.size = DEFAULT_SIZE;
        } else {
            if (Integer.bitCount(size) != 1) {
                throw new IllegalArgumentException("Consider size being " +
                        "1,2,4,8,16,32,64,128,256,512,1024,2048,4096... Where Integer.bitCount(size) == 1 ");
            }
            this.size = size;
        }
        this.bits = new BitArray(size);
    }

    public Integer getIndex(String value) {
        int index = value.hashCode() % size;
        return index >= 0 ? index : -index;
    }

    public Integer getAnotherIndex(String value) {
        int index = ((2 * value.hashCode()) + 3) % 5;
        return index >= 0 ? index : -index;
    }

    @Override
    public void add(String value) {
        Integer point1 = getIndex(value);
        Integer point2 = getAnotherIndex(value);
        bits.set(point1, true);
        bits.set(point2, true);
    }

    @Override
    public boolean mightContain(String value) {
        Integer point1 = getIndex(value);
        Integer point2 = getAnotherIndex(value);
        return bits.get(point1) && bits.get(point2);
    }

    public static void main(String[] args) {
        BloomFilterImpl filter = new BloomFilterImpl();
        filter.add("Valera");
        filter.add("Igor");

        System.out.println(filter.mightContain("Valera"));
        System.out.println(filter.mightContain("Igor"));
        System.out.println(filter.mightContain("Serhii"));
    }

}
