package by.bsu.algorithms.algorithm.breadthfirstsearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BreadthFirstSearch {
    private int[][] graph;
    private Map<Integer, Integer> result;

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public BreadthFirstSearch(int[][] graph) {
        this.graph = graph;
        result = new HashMap<>();
    }

    public Map<Integer,Integer> getResult(){
        return result;
    }

    public boolean isConnectedGraph(){
        tagVertices();
        return result.size()==graph.length;
    }

    public void tagVertices(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        int label = 0;
        int vertex = 0;
        stack1.add(vertex);
        doTagging(label);
    }

    private void doTagging(int label){
        int vertex;
        if (stack1.isEmpty()){
            return;
        }
        while (!stack1.isEmpty()){
            vertex = stack1.pop();
            for (int i = 0; i<graph.length; i++){
                if (graph[vertex][i]==1 && !stack1.contains(i) && !result.containsKey(i)){
                    stack2.push(i);
                }
            }
            result.put(vertex,label);
        }
        stack1.addAll(stack2);
        stack2.clear();
        doTagging(++label);
    }
}