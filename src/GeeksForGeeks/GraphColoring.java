package GeeksForGeeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class GraphColoring {
    class Vertex{
        LinkedList<Integer> nbrs = new LinkedList<>();
    }
    class Graph{
        HashMap<Integer,Vertex> vtcs = new HashMap<>();
        void addVertex(int vname){
            if(vtcs.containsKey(vname))
                return;
            else{
                Vertex vtx = new Vertex();
                vtcs.put(vname,vtx);
            }
        }
        void addEdge(int src,int dest){
            Vertex vtx1 = vtcs.get(src);
            Vertex vtx2 = vtcs.get(dest);
            if(vtx1==null||vtx2==null||vtx1.nbrs.contains(dest))
                return;
            else
                vtx1.nbrs.add(dest);
        }
        void graph_Color(int n){
            int color[] = new int[n];
            Arrays.fill(color,-1);
            color[0] = 0;
            boolean avail[] = new boolean[n];
            Arrays.fill(avail,true);
            for(int u=1;u<n;u++){

            }
        }
    }
}
