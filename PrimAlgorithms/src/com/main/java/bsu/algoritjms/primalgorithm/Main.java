package com.main.java.bsu.algoritjms.primalgorithm;

import java.util.Arrays;

import static com.main.java.bsu.algoritjms.primalgorithm.Prim.INF;
import static com.main.java.bsu.algoritjms.primalgorithm.Prim.WEIGHT;

public class Main {
    public static void main(String[] args) {
        int graph[][] = new int[][]{
                {   0,   6,   1, INF, INF, INF, INF, INF, INF},
                {   6,   0, INF,   4,   2, INF, INF, INF, INF},
                {   1, INF,   0,   2, INF,   3,   4, INF, INF},
                { INF,   4,   2,   0,   3,   2, INF,   1, INF},
                { INF,   2, INF,   3,   0, INF, INF, INF, INF},
                { INF, INF,   3,   2, INF,   0,   4,   2,   3},
                { INF, INF,   4, INF, INF,   4,   0, INF, INF},
                { INF, INF, INF,   1, INF,   2, INF,   0,   1},
                { INF, INF, INF, INF, INF,   3, INF,   1,   0}
        };
        Prim prim = new Prim(graph, 9);
        int[][] res = prim.getMinSkeleton(0);
        int weight = 0;

        for (int[] arr:res){
            if (arr[WEIGHT] != 0){
                weight+=arr[WEIGHT];
                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println(weight);

    }
}
