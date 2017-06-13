package com.simscale.primes.terminal;

import com.simscale.primes.algorithm.LogGenerator;
import com.simscale.primes.algorithm.SieveGenerator;
import com.simscale.primes.algorithm.StraightGenerator;

import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        try {
            String algorithmType = args[0];
            int start = Integer.parseInt(args[1]);
            int end = Integer.parseInt(args[2]);

            if (Objects.equals(algorithmType, "straight")) {
                ArrayList<Integer> primes = new StraightGenerator().generate(start, end);
                System.out.println(primes);
            } else if (Objects.equals(algorithmType, "log")) {
                ArrayList<Integer> primes = new LogGenerator().generate(start, end);
                System.out.println(primes);
            } else if (Objects.equals(algorithmType, "sieve")) {
                ArrayList<Integer> primes = new SieveGenerator().generate(start, end);
                System.out.println(primes);
            } else {
                throw new UnsupportedOperationException();
            }
        } catch (NumberFormatException e) {
            System.err.println("Start and end arguments must be integers");
            System.exit(1);
        } catch (UnsupportedOperationException e) {
            System.err.println("Algorithm type is invalid. Supported algorithms are: straight, log and sieve");
            System.exit(1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("3 arguments must be provided: algorithmType, start and end");
            System.exit(1);
        }

    }
}
