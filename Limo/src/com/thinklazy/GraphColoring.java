package com.thinklazy;

public class GraphColoring {
    public final static int V = 4;

    // driver program to test above function
    public static void main(String args[]) {
        /*
         * Create following graph and test whether it is 3 colorable (3)---(2) | / | | / | | / |
         * (0)---(1)
         */
        int graph[][] = { {0, 1, 1, 1}, 
                          {1, 0, 1, 0}, 
                          {1, 1, 0, 1}, 
                          {1, 0, 1, 0},};
        int m = 3; // Number of colors
        graphColoring(graph, m);
    }

    /*
     * A utility function to check if the current color assignment is safe for vertex v
     */
    static boolean isSafe(int v, int graph[][], int color[], int c) {
        for (int i = 0; i < V; i++)
            if (graph[v][i] == 1 && c == color[i])
                return false;
        return true;
    }

    /* A recursive utility function to solve m coloring problem */
    static boolean graphColoringUtil(int graph[][], int m, int color[], int v) {
        /*
         * base case: If all vertices are assigned a color then return true
         */
        if (v == V)
            return true;

        /* Consider this vertex v and try different colors */
        for (int c = 1; c <= m; c++) {
            /* Check if assignment of color c to v is fine */
            if (isSafe(v, graph, color, c)) {
                color[v] = c;

                /* recur to assign colors to rest of the vertices */
                if (graphColoringUtil(graph, m, color, v + 1) == true) {
                    return true;
                }

                /*
                 * If assigning color c doesn't lead to a solution then remove it
                 */
                color[v] = 0;
            }
        }

        /* If no color can be assigned to this vertex then return false */
        return false;
    }

    /*
     * This function solves the m Coloring problem using Backtracking. It mainly uses
     * graphColoringUtil() to solve the problem. It returns false if the m colors cannot be
     * assigned, otherwise return true and prints assignments of colors to all vertices. Please note
     * that there may be more than one solutions, this function prints one of the feasible
     * solutions.
     */
    static boolean graphColoring(int graph[][], int m) {
        // Initialize all color values as 0. This initialization is needed correct functioning of
        // isSafe()
        int[] color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;

        // Call graphColoringUtil() for vertex 0
        if (graphColoringUtil(graph, m, color, 0) == false) {
            System.out.println(String.format("Solution does not exist"));
            return false;
        }

        // Print the solution
        return true;
    }

    /* A utility function to print solution */
    void printSolution(int[] color) {
        System.out.println(String.format("Solution Exists:"
                + " Following are the assigned colors \n"));
        for (int i = 0; i < V; i++)
            System.out.println(String.format(" %d ", color[i]));
        System.out.println(String.format("\n"));
    }
}
