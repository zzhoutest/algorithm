package com.botforever;

import com.botforever.ds.MyGraph;

public class Main {
    private void testMyGraph() {
        String[] vertices = {"a", "z", "s", "x", "d", "c", "f", "v"};
        MyGraph g = new MyGraph(vertices);
        g.addEdge("a", new String[]{"z", "s"});
        g.addEdge("z", new String[]{"a"});
        g.addEdge("s", new String[]{"a", "x"});
        g.addEdge("x", new String[]{"s", "d", "c"});
        g.addEdge("d", new String[]{"x", "c", "f"});
        g.addEdge("c", new String[]{"x", "d", "f", "v"});
        g.addEdge("f", new String[]{"d", "c", "v"});
        g.addEdge("v", new String[]{"c", "f"});
        g.print();
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.testMyGraph();
    }
}
