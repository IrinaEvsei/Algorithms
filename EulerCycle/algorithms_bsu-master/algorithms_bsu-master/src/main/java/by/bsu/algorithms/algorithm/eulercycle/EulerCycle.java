package by.bsu.algorithms.algorithm.eulercycle;


import by.bsu.algorithms.algorithm.breadthfirstsearch.BreadthFirstSearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class EulerCycle {
    private int[][] graph;
    private List<Integer> cycle;

    public EulerCycle(int[][] graph){
        this.graph = graph;
        cycle = new LinkedList<>();
    }

    public List<Integer> getCycle(){
        return cycle;
    }

    public boolean isEulerGraph(){
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
        if (bfs.isConnectedGraph()){
            for (int[] row: graph){
                int deg = 0;
                for (int adjacency: row){
                    deg+=adjacency;
                }
                if (deg%2!=0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void findEulerCycle(){
        if (!isEulerGraph()){
            return;
        }
        int[][] graph = new int[this.graph.length][this.graph.length];
        for (int i=0; i<graph.length; i++){
            graph[i] = Arrays.copyOf(this.graph[i], this.graph.length);
        }
        Stack<Integer> stack = new Stack<>();
        int vertex = 0;
        stack.push(vertex);
        makeCycle(graph,stack);
    }

    private void makeCycle(int[][] graph, Stack<Integer> stack){
        int vertex;
        while (!stack.isEmpty()){
            vertex = stack.peek();
            for (int i = 0; i<graph.length;i++){
                if (graph[vertex][i]==1){
                    stack.push(i);
                    graph[vertex][i]=0;
                    graph[i][vertex]=0;
                    makeCycle(graph,stack);
                    break;
                }
            }
            if (!stack.isEmpty()){
                cycle.add(stack.pop());
            } else {
                break;
            }

        }
    }
}
