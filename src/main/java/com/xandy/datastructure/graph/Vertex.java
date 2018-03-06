package com.xandy.datastructure.graph;

/**
 * @author xandy
 * @Description
 * @since 2018/3/5 16:12
 */
public class Vertex {

    //订单名
    public char label;

    //是否被访问
    public boolean wasVisited;


    public Vertex(char label) {
        this.label = label;
        wasVisited = false;

    }
}
