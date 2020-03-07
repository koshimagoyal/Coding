package GeeksForGeeks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class DFS {
    static class Vertex{
        LinkedList<Integer> nbrs = new LinkedList<>();
    }
    static class Graph{
        HashMap<Integer,Vertex> vtcs = new HashMap<>();
        void addVertex(Integer vname){
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
        void dfs(int src,HashMap<Integer,Boolean> visited){
            visited.put(src,true);
            System.out.print(src+" ");
            Vertex v = vtcs.get(src);
            for(int i=0;i<v.nbrs.size();i++){
                if(!visited.containsKey(v.nbrs.get(i))) {
                    visited.put(v.nbrs.get(i), true);
                    dfs(v.nbrs.get(i), visited);
                }
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t>0){
            int v_size = sc.nextInt();
            int e_size = sc.nextInt();
            Graph g = new Graph();
            for(int i=0;i<e_size;i++){
                int src = sc.nextInt();
                g.addVertex(src);
                int dest = sc.nextInt();
                g.addVertex(dest);
                g.addEdge(src,dest);
            }
            g.dfs(0,new HashMap<>());
            System.out.println();
            t--;
        }
    }
}
