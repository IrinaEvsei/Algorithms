package com.main.java.bsu.algorithms.huffman;

import java.io.Serializable;
import java.math.BigDecimal;

public class Node implements Serializable{
    private static final long serialVersionUID = 1L;

    private char value;
    private BigDecimal frequency;
    private Node left;
    private Node right;

    Node(char val, BigDecimal freq){
        this.value = val;
        this.frequency = freq;
    }

    public char getValue() {
        return value;
    }
    public void setValue(char value) {
        this.value = value;
    }
    public BigDecimal getFrequency() {
        return frequency;
    }
    public void setFrequency(BigDecimal frequency) {
        this.frequency = frequency;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}