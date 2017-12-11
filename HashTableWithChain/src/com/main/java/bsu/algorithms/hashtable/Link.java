package com.main.java.bsu.algorithms.hashtable;

class Link {

    private int iData; // Данные
    public Link next; // Следующий элемент списка

    // Конструктор
    public Link(int it){
        iData= it;
    }

    public int getKey() {
        return iData;
    }

    public void displayLink() { // Вывод содержимого элемента
        System.out.print(iData + " ");
    }
}
