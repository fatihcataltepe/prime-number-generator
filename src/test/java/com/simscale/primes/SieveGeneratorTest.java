package com.simscale.primes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SieveGeneratorTest {

    SieveGenerator generator = new SieveGenerator();
    @Test
    public void generate() throws Exception {
        System.out.println("Testing generate1()");

        ArrayList<Integer> actual = generator.generate(1, 10);
        List<Integer> expected = new ArrayList<>(Arrays.asList(2, 3, 5, 7));

        assertEquals(expected, actual);
    }

    @Test
    public void generate2() throws Exception {
        System.out.println("Testing generate2()");

        ArrayList<Integer> actual = generator.generate(1087, 1152);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151));

        assertEquals(expected, actual);
    }

    @Test
    public void generate3() throws Exception {
        System.out.println("Testing generate3()");

        ArrayList<Integer> actual = generator.generate(-10, 10);
        List<Integer> expected = new ArrayList<>(Arrays.asList(2, 3, 5, 7));

        assertEquals(expected, actual);
    }

    @Test
    public void generate4() throws Exception {
        System.out.println("Testing generate4()");

        ArrayList<Integer> actual = generator.generate(-10, 0);
        List<Integer> expected = new ArrayList<>(Arrays.asList());

        assertEquals(expected, actual);
    }

}