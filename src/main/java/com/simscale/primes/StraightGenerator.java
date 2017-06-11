package com.simscale.primes;

import java.util.ArrayList;


/**
 * Straight prime number generator
 * Runs in O(n^2) time complexity
 */
public class StraightGenerator implements PrimeNumberGenerator {

    //O(n)
    @Override
    public ArrayList<Integer> generate(int start, int end) {
        ArrayList res = new ArrayList();

        for (int i = start; i < end; i++) {
            if (isPrime(i)) res.add(i);
        }
        return res;
    }

    //O(n)
    private Boolean isPrime(int value) {
        if (value < 2) return false;

        for (int i = 2; i < value; i++) {
            if (value % i == 0) return false;
        }
        return true;
    }
}
