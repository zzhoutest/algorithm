package com.botforever.ds;

public class MyNode {
    public String data;
    public MyNode[] neighbors;
    public int level = -1;
    public MyNode parent;
    public MyNode next;

    public MyNode(String data) {
        this.data = data;
    }
}
