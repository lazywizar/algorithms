package com.thinklazy;

public class CyclicGraph {
    // // Directed graph
    static boolean hasCycle(Graphnode n) {
        n.setMark(inProgress);
        Iterator it = n.getSuccessors().iterator();
        while (it.hasNext()) {
            Graphnode m = it.next();
            if (m.getMark() == inProgress)
                return true;
            if (m.getMark() != done) {
                if (hasCycle(m))
                    return true;
            }
        }
        n.setMark(done);
        return false;
    }

    // Note that if we want to know whether a graph contains a cycle anywhere
    // (not just one that is reachable from node n)
    // we might have to call hasCycle at the
    // "top-level" more than once. Here's a pseudo-code version of a method of the Graph class that
    // returns true iff there is a cycle somewhere in the graph:
    public boolean graphHasCycle() {
         mark all nodes unvisited;
         for each node k in the graph {
            if (node k is marked unvisited) {
               if (hasCycle(k)) return true;
            }
         }
         return false;
     }
    //

    //////////////// UNDIRECTRED 
    bool Graph::isCyclicUtil(int v, bool visited[], int parent)
    {
        // Mark the current node as visited
        visited[v] = true;
     
        // Recur for all the vertices adjacent to this vertex
        list<int>::iterator i;
        for (i = adj[v].begin(); i != adj[v].end(); ++i)
        {
            // If an adjacent is not visited, then recur for that adjacent
            if (!visited[*i])
            {
               if (isCyclicUtil(*i, visited, v))
                  return true;
            }
     
            // If an adjacent is visited and not parent of current vertex,
            // then there is a cycle.
            else if (*i != parent)
               return true;
        }
        return false;
    }
     
    // Returns true if the graph contains a cycle, else false.
    bool Graph::isCyclic()
    {
        // Mark all the vertices as not visited and not part of recursion
        // stack
        bool *visited = new bool[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
     
        // Call the recursive helper function to detect cycle in different
        // DFS trees
        for (int u = 0; u < V; u++)
            if (!visited[u] && isCyclicUtil(u, visited, -1))
                return true;
     
        return false;
    }
    
    
}
