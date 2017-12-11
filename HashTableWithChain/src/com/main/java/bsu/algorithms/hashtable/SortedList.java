package com.main.java.bsu.algorithms.hashtable;

class SortedList {

    private Link first; // Ссылка на первый элемент списка

    public void SortedList() {// Конструктор
        first = null;
    }

    // Вставка в порядке сортировки
    public void insert(Link theLink) {
        int key = theLink.getKey();
        Link previous = null; // Начиная с первого элемента
        Link current = first;

        while( current != null && key > current.getKey() )
        {
            previous = current;
            current = current.next; // Переход к следующему элементу
        }
        if(previous==null) // В начале списка
            first = theLink; // first --> новый элемент
        else // Не в начале
            previous.next = theLink; // prev --> новый элемент
        theLink.next = current; // новый элемент --> current
    }

    // Удаление элемента
    public void delete(int key) {
        Link previous = null; // Начиная с первого элемента
        Link current = first;

        while( current != null && key != current.getKey() ) {
            previous = current;
            current = current.next; // Переход к следующему элементу
        }
        if(previous==null) {
            first = first.next;// изменить first
        }
        else {
            previous.next = current.next;// удалить текущий элемент
        }
    }

    // Поиск элемента с заданным ключом
    public Link find(int key) {
        Link current = first;

        while(current != null && current.getKey() <= key) {
            if(current.getKey() == key) { // Искомый элемент?
                return current;// Совпадение обнаружено
            }
            current = current.next; // Переход к следующему элементу
        }
        return null; // Элемент не найден
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first; // От начала списка
        while(current != null) {// Перемещение до конца списка
            current.displayLink(); // Вывод данных
            current = current.next; // Переход к следующему элементу
        }
        System.out.println("");
    }
}
