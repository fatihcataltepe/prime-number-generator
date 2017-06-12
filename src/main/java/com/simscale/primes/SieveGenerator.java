package com.simscale.primes;

import java.util.ArrayList;

public class SieveGenerator implements PrimeNumberGenerator {
    @Override
    public ArrayList<Integer> generate(int start, int end) {
        //ignore negative numbers
        start = Math.max(2, start);

        //mark if the number is not prime
        boolean[] isComposite = new boolean[end + 1];
        for (int i = 2; i * i <= end; i++) {
            if (!isComposite[i]) {
                for (int j = i; i * j <= end; j++) {
                    isComposite[i * j] = true;
                }
            }
        }

        //return the prime numbers
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (!isComposite[i]) primes.add(i);
        }
        return primes;
    }
}
