package sample;

import java.util.ArrayList;

public class TwoOpt {

    private final int ITERATION = 20;
    private int numberOfNodes;
    private ArrayList<Integer> path;
    private int adjMatrix[][];

    public TwoOpt(ArrayList<Integer> path, int adjMatrix[][]) {
        this.path = path;
        this.adjMatrix = adjMatrix;
        numberOfNodes = path.size();
    }

    public int getDistance(ArrayList<Integer> newPath) {
        if (newPath.size() <= 1) return 0;

        int dist = 0;
        int node1 = newPath.get(0);
        for (int i = 1; i < newPath.size(); i++) {
            dist += adjMatrix[node1][newPath.get(i)];
            node1 = newPath.get(i);
        }

        return dist;
    }

    public ArrayList<Integer> twoOptSwap(ArrayList<Integer> path, int x, int y) {
        ArrayList<Integer> newPath = new ArrayList<Integer>();

        for (int i = 0; i < x; i++) {
            newPath.add(path.get(i));
        }

        int k = 0;
        for (int i = x; i <= y; i++) {
            newPath.add(path.get(y-k));
            k++;
        }

        for (int i = y+1; i < path.size(); i++) {
            newPath.add(path.get(i));
        }

        return newPath;
    }

    public ArrayList<Integer> optimize() {
        int tmp = 0;

        while (tmp < ITERATION) {
            int dist = getDistance(path);

            for (int i = 0; i < numberOfNodes-1; i++) {
                for (int j = i+1; j < numberOfNodes; j++) {
                    ArrayList<Integer> newPath = twoOptSwap(path, i, j);
                    int newDist = getDistance(newPath);

                    if (newDist < dist) {
                        tmp = 0;
                        path = newPath;
                        dist = newDist;
                    }
                }
            }

            tmp++;
        }

        return path;
    }
}

