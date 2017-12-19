package com.main.java.bsu.algorithms.kraskalalgorithm;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0,1,6},
                {0,2,10},
                {1,3,4},
                {1,4,2},
                {3,4,3},
                {2,3,2},
                {2,6,4},
                {2,5,3},
                {6,5,4},
                {3,5,2},
                {3,7,4},
                {5,7,2},
                {5,8,3},
                {8,7,1},
                {2,7,1}
        };
        Kraskal kraskal = new Kraskal(graph, 9);
        int[][] result = kraskal.getMinGraph();
        for (int[] arr:result){
            if (arr[Kraskal.WEIGHT] != 0){
                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println(kraskal.getWeight());
    }
}
