package sample;

import java.util.ArrayList;
import java.util.Stack;

public class GreedyTSP {

    private final int DIST = 1;
    private int numberOfNodes;
    private int adjMatrix[][];
    private Stack<Integer> stack;
    private ArrayList<Integer> path;

    public GreedyTSP(int adjMatrix[][]) {
        this.adjMatrix = adjMatrix;
        numberOfNodes = adjMatrix.length;
        stack = new Stack<Integer>();
        path = new ArrayList<Integer>();
    }

    public ArrayList<Integer> shortestPath() {
        int visited[] = new int[numberOfNodes];

        visited[0] = 1;
        stack.push(0);
        path.add(0);
        // System.out.print(0 + "\t");

        int currentNode, nextNode = 0;
        boolean minFlag = false;

        while (!stack.isEmpty()) {
            currentNode = stack.peek();
            int min = DIST; // All distance values should be negative

            for (int i = 0; i < numberOfNodes; i++) {
                int dist = adjMatrix[currentNode][i];

                if (dist < DIST && visited[i] == 0) {
                    if (dist < min) {
                        min = dist;
                        nextNode = i;
                        minFlag = true;
                    }
                }
            }

            if (minFlag) {
//				System.out.print(nextNode + "\t");
                visited[nextNode] = 1;
                stack.push(nextNode);
                path.add(nextNode);
                minFlag = false;
                continue;
            }
            stack.pop();
        }
        return path;
    }
}