package com.thinklazy;

import java.util.Queue;
import java.util.LinkedList;

public class FloodFill {
    public static void main(String args[]) {
        int M[][] = { {1, 1, 1, 0, 1}, 
                      {1, 0, 1, 0, 1}, 
                      {1, 0, 0, 1, 1}, 
                      {1, 1, 0, 0, 1}};

        int m = M.length;
        int n = M[0].length;
        floodFill(M, 0, 5, 1, 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void floodFill(int[][] m, int fromColor, int toColor, int x, int y) {
        Queue<Point> unvisited = new LinkedList<Point>();
        if (m[x][y] != fromColor) {
            return;
        }
        unvisited.add(new Point(x, y));

        while (!unvisited.isEmpty()) {
            Point p = unvisited.remove();
            if (!(p.x >= 0 && p.x < m.length && p.y >= 0 && p.y < m[0].length && m[p.x][p.y] == fromColor)) {
                continue;
            }
            m[p.x][p.y] = toColor;
            unvisited.add(new Point(p.x - 1, p.y));
            unvisited.add(new Point(p.x + 1, p.y));
            unvisited.add(new Point(p.x, p.y - 1));
            unvisited.add(new Point(p.x, p.y + 1));
        }

    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

}
