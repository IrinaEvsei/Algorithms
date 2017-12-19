package com.main.java.bsu.algorithms.bfs;

class Queue {
    private final int SIZE = 20;
    private int[] queArray;
    private int front;
    private int rear;

    public Queue() {// Конструктор
        queArray = new int[SIZE];
        front = 0;
        rear = -1;
    }

    // Вставка элемента в конец очереди
    public void insert(int j) {
        if(rear == SIZE-1)
            rear = -1;
        queArray[++rear] = j;
    }

    // Извлечение элемента в начале очереди
    public int remove() {
        int temp = queArray[front++];
        if(front == SIZE)
            front = 0;
        return temp;
    }

    public boolean isEmpty() {// true, если очередь пуста
        return ( rear+1==front || (front+SIZE-1==rear) );
    }

}