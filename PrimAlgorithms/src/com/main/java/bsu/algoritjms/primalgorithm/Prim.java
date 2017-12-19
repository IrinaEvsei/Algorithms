package com.main.java.bsu.algoritjms.primalgorithm;

public class Prim {
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    public static final int INF = Integer.MIN_VALUE;

    public static final int WEIGHT = 2;

    private int[] labels;
    private boolean[] visited;
    private int[][] graph;
    private int[][] result;

    public Prim(int[][] graph, int vertex){
        this.graph = graph;
        labels = new int[vertex];
        result = new int[graph.length*2][3];
        visited = new boolean[vertex];
        labels = new int[vertex];
        for (int i = 0; i<labels.length; i++){
            labels[i] = i;
        }
    }

    public int[][] getMinSkeleton(int start){
        int position = 0;
        int min = MAX_VALUE;
        int nextVertex = start;
        visited[start] = true;
        for (int i = 0; i<graph.length;i++){
            if (graph[start][i]>0 && graph[start][i]<min){
                min = graph[start][i];
                nextVertex = i;
            }
        }
        visited[nextVertex] = true;
        labels[nextVertex] = labels[start];
        result[position] = new int[]{start, nextVertex, min};
        position++;

        while(!allAdded()){
            min = MAX_VALUE;
            int currentVertex = start;
            for (int i = 0; i<graph.length;i++){
                if (visited[i]){
                    for (int j = 0;j<graph.length;j++){
                        if (labels[i]==labels[j]){
                            continue;
                        }
                        if(graph[i][j]>0 && graph[i][j]<min){
                            min = graph[i][j];
                            currentVertex = i;
                            nextVertex=j;
                        }
                    }
                }
            }

            visited[nextVertex] = true;

            int valueToChange = labels[nextVertex];
            int changeValue = labels[currentVertex];
            for (int k=0; k<labels.length; k++){
                if (labels[k] == valueToChange){
                    labels[k] = changeValue;
                }
            }

            result[position] = new int[]{currentVertex, nextVertex, min};
            position++;
        }


        return result;
    }

    private boolean allAdded(){
        for (boolean value: visited) {
            if (!value){
                return false;
            }
        }
        return true;
    }
}