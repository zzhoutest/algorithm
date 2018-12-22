package com.botforever;

import com.botforever.ds.MyGraph;
import com.botforever.leetcode.Solution;

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
        g.shortest("s","v");
    }

    private void printIntArray(int[] array) {
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
    private void testLeetCode(Solution solution, String q) {
        if (q.equalsIgnoreCase("plusOne")) {
            int[] digits = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
            printIntArray(solution.plusOne(digits));
        }
        if (q.equalsIgnoreCase("findDiagonalOrder")) {
            int[][] matrix = {{2,5},{8,4},{0,-1}};//{{1,2,3},{4,5,6},{7,8,9}};
            printIntArray(solution.findDiagonalOrder(matrix));
        }
        if (q.equalsIgnoreCase("addBinary")) {
            System.out.println(solution.addBinary("11","1"));
        }
        if (q.equalsIgnoreCase("minSubArrayLen")) {
            int s = 7;
            int[] nums = {2,3,1,2,4,3};
            System.out.println(solution.minSubArrayLen(s, nums));
        }
    }

    public static void main(String[] args) {
        Main app = new Main();
        //app.testMyGraph();
        Solution solution = new Solution();
        app.testLeetCode(solution, "minSubArrayLen");

    }
}
