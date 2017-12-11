package com.main.java.bsu.algorithms.dfs;

class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // Список вершин
    private int adjMat[][]; // Матрица смежности
    private int nVerts; // Текущее количество вершин
    private StackX theStack;

    // Конструктор
    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS]; // Матрица смежности
        nVerts = 0;
        for(int j=0; j<MAX_VERTS; j++) // Матрица смежности
            for(int k=0; k<MAX_VERTS; k++) // заполняется нулями
                adjMat[j][k] = 0;
        theStack = new StackX();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    // Обход в глубину
    public void dfs() {
     // Алгоритм начинает с вершины 0
        vertexList[0].wasVisited = true; // Пометка
        displayVertex(0); // Вывод
        theStack.push(0); // Занесение в стек
        while( !theStack.isEmpty() ) {// Пока стек не опустеет
            // Получение непосещенной вершины, смежной к текущей
            int v = getAdjUnvisitedVertex( theStack.peek() );
            if(v == -1) { // Если такой вершины нет,
                theStack.pop(); // элемент извлекается из стека
            }
            else {// Если вершина найдена
                vertexList[v].wasVisited = true; // Пометка
                displayVertex(v); // Вывод
                theStack.push(v); // Занесение в стек
            }
        }
        // Стек пуст, работа закончена
        for(int j=0; j<nVerts; j++) // Сброс флагов
            vertexList[j].wasVisited = false;
    }

    // Метод возвращает непосещенную вершину, смежную по отношению к v
    public int getAdjUnvisitedVertex(int v) {
        for(int j=0; j<nVerts; j++)
            if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
                return j; // Возвращает первую найденную вершину
        return -1; // Таких вершин нет
    }

}
