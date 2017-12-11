package by.bsu.algorithms.main;


import by.bsu.algorithms.algorithm.eulercycle.EulerCycle;

public class EulerCycleRunner {
    public static void main(String[] args) {
        int graph[][] = {
                {0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0},
                {0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1},
                {0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                {0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0},
        };
        EulerCycle eulercycle = new EulerCycle(graph);
        eulercycle.findEulerCycle();
        System.out.println(eulercycle.getCycle());
    }
}
