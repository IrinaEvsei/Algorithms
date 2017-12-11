package by.bsu.algorithms.main;

import by.bsu.algorithms.algorithm.breadthfirstsearch.BreadthFirstSearch;

public class BreadthFirstSearchRunner {
    public static void main(String[] args) {
        int graph[][] = {
                {0, 1, 0, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
        };
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
        bfs.tagVertices();
        System.out.println(bfs.getResult());
        System.out.println(bfs.isConnectedGraph());
    }
}