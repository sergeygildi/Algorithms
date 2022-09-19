package com.company.BloomFilter;

/**
 * BloomFilter implementation interface
 */
interface BloomFilter {
    void add(String value);
    boolean mightContain(String value);
}
