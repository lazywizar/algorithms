package com.thinklazy;

public class CyclicGraph {
    //// Directed graph
    static boolean hasCycle(Graphnode n) {
        n.setMark( inProgress );
        Iterator it = n.getSuccessors().iterator();
        while(it.hasNext()) {
           Graphnode m = it.next();
           if (m.getMark() == inProgress) return true;
           if (m.getMark() != done) {
              if (hasCycle(m)) return true;
           }
        }
        n.setMark( done );
        return false;
     }
     Note that if we want to know whether a graph contains a cycle anywhere (not just one that is reachable from node n) we might have to call hasCycle at the "top-level" more than once. Here's a pseudo-code version of a method of the Graph class that returns true iff there is a cycle somewhere in the graph:
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

}
