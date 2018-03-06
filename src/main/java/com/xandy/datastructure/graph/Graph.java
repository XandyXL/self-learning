package com.xandy.datastructure.graph;

/**
 * 无向无权图
 *
 * @author xandy
 * @Description
 * @since 2018/3/5 15:34
 */
public class Graph {

    //最大下标
    private final int MAX_INDEX = 20;
    //顶点列表
    private Vertex verticesList[];
    //邻接矩阵
    private int adjMat[][];
    //顶点数
    private int nVerts;
    //深度优先搜索
    private Stack theStack;

    public Graph() {

        verticesList = new Vertex[MAX_INDEX];
        nVerts = 0;
        adjMat = new int[MAX_INDEX][MAX_INDEX];

        //init adjMat value
        for (int i = 0; i < MAX_INDEX; i++) {
            for (int j = 0; j < MAX_INDEX; j++) {
                adjMat[i][j] = 0;
            }
        }

        theStack = new Stack();

    }

    /**
     * add vertex
     *
     * @param label
     */
    public void addVertex(char label) {
        verticesList[nVerts++] = new Vertex(label);
    }

    /**
     * add edge
     *
     * @param start
     * @param end
     */
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    /**
     * show vertex
     *
     * @param v
     */
    public void displayVertex(int v) {
        System.out.print(verticesList[v].label);
    }

    /**
     * 获取未被访问的顶点
     *
     * @param v
     * @return
     */
    public int getAdjUnvisitedVernex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && !verticesList[j].wasVisited) {
                return j;
            }
        }
        return -1;
    }


    /**
     * 深度优先搜索
     */
    public void dfs() {
        //标记访问
        verticesList[0].wasVisited = true;
        //展示
        displayVertex(0);
        //入栈
        theStack.push(0);

        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVernex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                //标记访问
                verticesList[v].wasVisited = true;
                //展示
                displayVertex(v);
                //出栈
                theStack.push(v);
            }
        }

        //重置访问
        for (int j = 0; j < nVerts; j++) {
            verticesList[j].wasVisited = false;
        }
    }


    public static void main(String[] args) {
        Graph theGraph = new Graph();
        //0
        theGraph.addVertex('A');
        //1
        theGraph.addVertex('B');
        //2
        theGraph.addVertex('C');
        //3
        theGraph.addVertex('D');
        //4
        theGraph.addVertex('E');

        //AB
        theGraph.addEdge(0, 1);
        //BC
        theGraph.addEdge(1, 2);
        //AD
        theGraph.addEdge(0, 3);
        //DE
        theGraph.addEdge(3, 4);

        System.out.println("Visit:");
        theGraph.dfs();
        System.out.println();

    }

}
