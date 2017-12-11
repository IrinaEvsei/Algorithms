package com.main.java.bsu.algorithms.hashtable;

class HashTable {
    private SortedList[] hashArray; // Массив списков
    private int arraySize;

    // Конструктор
    public HashTable(int size) {
        arraySize = size;
        hashArray = new SortedList[arraySize]; // Создание массива
        for(int j=0; j<arraySize; j++) // Заполнение массива
            hashArray[j] = new SortedList(); // списками
    }

    public void displayTable() {
        for(int j=0; j<arraySize; j++) // Для каждой ячейки
        {
            System.out.print(j + ". "); // Вывод номера ячейки
            hashArray[j].displayList(); // Вывод списка
        }
    }

    // Хеш-функция
    public int hashFunc(int key) {
        return key % arraySize;
    }

    // Вставка элемента
    public void insert(Link theLink) {
        int key = theLink.getKey();
        int hashVal = hashFunc(key); // Хеширование ключа
        hashArray[hashVal].insert(theLink); // Вставка в позиции hashVal
    }

    // Удаление элемента
    public void delete(int key) {
        int hashVal = hashFunc(key); // Хеширование ключа
        hashArray[hashVal].delete(key); // Удаление
    }

    // Поиск элемента
    public Link find(int key) {
        int hashVal = hashFunc(key); // Хеширование ключа
        Link theLink = hashArray[hashVal].find(key); // Поиск
        return theLink; // Метод возвращает найденный элемент
    }

}
