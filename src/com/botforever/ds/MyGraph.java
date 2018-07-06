package com.botforever.ds;

import java.util.HashMap;

public class MyGraph {
    public MyNode[] vertices;

    public MyGraph(String[] data) {
        vertices = new MyNode[data.length];
        for (int i = 0; i < data.length; i++) {
            vertices[i] = new MyNode(data[i]);
        }
    }

    public MyNode findVertex(String data) {
        for (MyNode v : vertices) {
            if (v.data.equalsIgnoreCase(data)) {
                return v;
            }
        }
        return null;
    }

    public void addEdge(String vertex, String[] neighbors) {
        MyNode v = findVertex(vertex);
        if (v != null) {
            v.neighbors = new MyNode[neighbors.length];
            for (int i = 0; i < neighbors.length; i++) {
                v.neighbors[i] = findVertex(neighbors[i]);
            }
        }
    }

    public void print() {
        System.out.print("V = {");
        int i;
        for (i = 0; i < vertices.length - 1; i++) {
            System.out.print(vertices[i].data + ", ");
        }
        System.out.println(vertices[i].data + "}");
        System.out.print("E = {");
        for (i = 0; i < vertices.length - 1; i++) {
            for (int j = 0; j < vertices[i].neighbors.length; j++) {
                System.out.print("{" + vertices[i].data + "," + vertices[i].neighbors[j].data + "},");
            }
        }
        int j;
        for (j = 0; j < vertices[i].neighbors.length - 1; j++) {
            System.out.print("{" + vertices[i].data + "," + vertices[i].neighbors[j].data + "},");
        }
        System.out.println("{" + vertices[i].data + "," + vertices[i].neighbors[j].data + "}}");
    }

    public void reset() {
        for (MyNode vertex : vertices) {
            vertex.level = -1;
            vertex.parent = null;
        }
    }

    public void resetNext() {
        for (MyNode vertex : vertices) {
            vertex.next = null;
        }
    }
    /*
    BFS (V, Adj, s):
        level = {s:0}
        parent = {s:None}
        i = 1
        frontier = [s]
        while frontier:
            next = []
            for u in frontier:
                for v in Adj[u]:
                    if v not in level:
                        level[v] = i;
                        parent[v] = u;
                        next.append(v);
            frontier = next
            i += 1
     */
    public void bfs(MyNode s) {
        this.reset();
        if (s != null) {
            s.level = 0;
            s.parent = null;
            //System.out.println(s.data + " null"  + " " + s.level);
        }
        int i = 1;
        MyLinkedList frontier = new MyLinkedList(s);
        while (frontier.length() != 0) {
            MyLinkedList next = new MyLinkedList();
            MyNode u = frontier.head;
            while (u != null) {
                for (int j = 0; j < u.neighbors.length; j++) {
                    MyNode v = u.neighbors[j];
                    if (v.level == -1) {
                        v.level = i;
                        v.parent = u;
                        next.append(v);
                        //System.out.println(v.data + " " + v.parent.data + " " + v.level);
                    }
                }
                u = u.next;
            }
            frontier = next;
            i++;
        }
        resetNext();
    }

    public void shortest(String s, String e) {
        System.out.println();
        System.out.print("shortest route between " + s + " and " + e + ": ");
        MyNode start = findVertex(s);
        MyNode end = findVertex(e);
        if (start != null && end != null) {
            bfs(start);
            if (end.level != -1) {
                end.printParents();
            } else {
                System.out.println("not found.");
            }
        } else {
            System.out.println("invalid input.");
        }
    }
}
