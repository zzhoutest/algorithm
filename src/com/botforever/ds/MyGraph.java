package com.botforever.ds;

public class MyGraph {
    public MyVertex[] vertices;

    public MyGraph(String[] labels) {
        vertices = new MyVertex[labels.length];
        for (int i = 0; i < labels.length; i++) {
            vertices[i] = new MyVertex(labels[i]);
        }
    }

    public MyVertex findVertex(String label) {
        for (MyVertex v : vertices) {
            if (v.label.equalsIgnoreCase(label)) {
                return v;
            }
        }
        return null;
    }

    public void addEdge(String vertex, String[] neighbors) {
        MyVertex v = findVertex(vertex);
        if (v != null) {
            v.neighbors = new MyVertex[neighbors.length];
            for (int i = 0; i < neighbors.length; i++) {
                v.neighbors[i] = findVertex(neighbors[i]);
            }
        }
    }

    public void print() {
        System.out.print("V = {");
        int i;
        for (i = 0; i < vertices.length - 1; i++) {
            System.out.print(vertices[i].label + ", ");
        }
        System.out.println(vertices[i].label + "}");
        System.out.print("E = {");
        for (i = 0; i < vertices.length - 1; i++) {
            for (int j = 0; j < vertices[i].neighbors.length; j++) {
                System.out.print("{" + vertices[i].label + "," + vertices[i].neighbors[j].label + "},");
            }
        }
        int j;
        for (j = 0; j < vertices[i].neighbors.length - 1; j++) {
            System.out.print("{" + vertices[i].label + "," + vertices[i].neighbors[j].label + "},");
        }
        System.out.println("{" + vertices[i].label + "," + vertices[i].neighbors[j].label + "}}");
    }
}
