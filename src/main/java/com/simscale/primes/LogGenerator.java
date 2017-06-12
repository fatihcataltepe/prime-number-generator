package com.simscale.primes;

import java.util.ArrayList;

/**
 * Log prime number generator
 * Runs in O(N√N) time complexity
 * <p>
 * For more information of sqrt search see `https://codereview.stackexchange.com/questions/10823/yet-another-prime-number-generator`
 */
public class LogGenerator implements PrimeNumberGenerator {

    //O(n)
    @Override
    public ArrayList<Integer> generate(int start, int end) {
        ArrayList res = new ArrayList();

        for (int i = start; i < end; i++) {
            if (isPrime(i)) res.add(i);
        }
        return res;
    }


    // O(sqrt N)
    private boolean isPrime(int value) {
        double sqrt = Math.sqrt(value);
        double max = Math.floor(sqrt);

        if (value < 2) return false;
        for (int i = 2; i <= max; i++) {
            if (value % i == 0) return false;
        }
        return true;
    }
}
