package sample;

import java.io.File;
import java.util.Scanner;

public class InputFileProcessor {

    private File file;
    private int numberOfNodes;
    private int adjMatrix[][];

    public InputFileProcessor (String fName, int numNodes) {
        this.numberOfNodes = numNodes;
        adjMatrix = new int[numNodes][numNodes];
        file = new File("src/sample/input.txt");
    }

    public int[][] initializeMatrix() throws Exception {
        Scanner scanner = new Scanner(file);

        int i = 0;
        while (scanner.hasNext() && i < numberOfNodes) {
            String line[] = scanner.nextLine().split(" ");

            if (line.length != numberOfNodes) {
                System.out.println(line.length);
                System.out.println("Invalid input.txt matrix size - (N x N)");
                break;
            }

            for (int j = 0; j < numberOfNodes; j++) {
                adjMatrix[i][j] = Integer.parseInt(line[j]);
            }

            i++;
        }

        scanner.close();
        return adjMatrix;
    }
}

