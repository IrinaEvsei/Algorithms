package com.main.java.bsu.algorithms.huffman;

import java.util.Comparator;

public class Compare implements Comparator<Node> {
    @Override
    public int compare(Node a, Node b) {
        return b.getFrequency().compareTo(a.getFrequency());
    }
}
