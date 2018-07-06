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

    public void printParents() {
        if (parent != null) {
            System.out.print(data + "<-");
        } else {
            System.out.println(data);
            return;
        }

        MyNode node = parent;
        while (node != null) {
            if (node.parent != null) {
                System.out.print(node.data + "<-");
            } else {
                System.out.print(node.data);
            }
            node = node.parent;
        }

    }
}
