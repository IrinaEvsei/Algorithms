package com.main.java.bsu.algorithms.kraskalalgorithm;


public class Kraskal {

    public final static int FIRST = 0;
    public final static int SECOND = 1;
    public static final int WEIGHT = 2;

    private int[] label;
    private int weight;
    private int[][] edges;

    private int[][] result;

    public Kraskal(){}

    public Kraskal(int[][] graph, int vertex){
        edges = graph;
        result = new int[edges.length][3];
        initLabel(vertex);
    }

    public int getWeight() {
        return weight;
    }

    public void initLabel(int length){
        label = new int[length];
        for (int i = 0; i<label.length; i++){
            label[i] = i;
        }
    }

    public int[][] getMinGraph(){
        doSorting();
        weight=0;
        result[0] = edges[0];
        label[edges[0][SECOND]] = edges[0][FIRST];
          weight += edges[0][WEIGHT];
        int i = 1;
        for (int j = 1; j<edges.length; j++){
            if (label[edges[j][FIRST]]==label[edges[j][SECOND]]){
                continue;
            }

            int valueToChange = label[edges[j][SECOND]];
            int changeValue = label[edges[j][FIRST]];
            for (int k=0; k<label.length; k++){
                if (label[k] == valueToChange){
                    label[k] = changeValue;
                }
            }
            weight+=edges[j][WEIGHT];

            result[i++]=edges[j];
        }
        return result;
    }


    private void doSorting(){
        sort(0, edges.length-1);
    }

    private void sort(int start, int end){
        if (start>=end){
            return;
        }
        int i=start;
        int j=end;
        int cur=i-(i-j)/2;
        while(i<j){
            while(i<cur&&edges[i][WEIGHT]<=edges[cur][WEIGHT]){
                i++;
            }
            while(j>cur&&edges[j][WEIGHT]>=edges[cur][WEIGHT]){
                j--;
            }
            if (i<j){
                swap(i,j);
                if (i==cur){
                    cur=j;
                }
                else if (j==cur){
                    cur=i;
                }
            }
        }
        sort(start,cur);
        sort(cur+1, end);
    }

    private void swap(int i, int j){
        int[] temp = edges[i];
        edges[i]=edges[j];
        edges[j]=temp;
    }
}