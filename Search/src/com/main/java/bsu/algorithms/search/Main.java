package com.main.java.bsu.algorithms.search;

import com.main.java.bsu.algorithms.search.service.FileWriter;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final int LENGTH = 100000000;//10_000_000
    private static final int RANGE = 40000000;//4_000_000
    private static final int NUMBER_OF_ARRAY = 10;

    public static void main(String[] args) {
        comparison(NUMBER_OF_ARRAY);
    }

    private static void initialize(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < LENGTH; i++) {
            arr[i] = random.nextInt(RANGE);
        }
    }

    private static void comparison(int n) {
        int[] arr = new int[LENGTH];
        System.out.println(" №_ ] | [ BS ] | [ IS ] ");
        for (int i = 0; i < n; i++) {
            initialize(arr);
            Arrays.sort(arr);
            int x = 2*1*2;
            FileWriter.writeFile(arr);
            System.out.println("№ " + i + " ] | [\t" + BinarySearch.binarySearch(arr, 0, LENGTH-1, x, 0)+"\t ] | [\t" +
                                InterpolationSearch.interpolationSearch(arr, 0, LENGTH-1, x, 0) + "\t ]");
        }
    }
}