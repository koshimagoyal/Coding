package GeeksForGeeks;

import java.util.*;

public class BFS {
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
        void addEdge(Integer src,Integer dest){
            Vertex vtx1 = vtcs.get(src);
            Vertex vtx2 = vtcs.get(dest);
            if(vtx1==null||vtx2==null||vtx1.nbrs.contains(dest))
                return;
            else
                vtx1.nbrs.add(dest);
        }
        void print(){
            for(Map.Entry<Integer,Vertex> entry:vtcs.entrySet()){
                System.out.print(entry.getKey());
                for(int i=0;i<entry.getValue().nbrs.size();i++){
                    System.out.print(" "+entry.getValue().nbrs.get(i));
                }
                System.out.println();
            }
        }
        void bfs(Integer src){
            HashMap<Integer,Boolean> visited = new HashMap<>();
            LinkedList<Integer> queue = new LinkedList<>();
            visited.put(src,true);
            queue.add(src);
            while(!queue.isEmpty()){
                Integer n = queue.poll();
                System.out.print(n+" ");
                Vertex vtx = vtcs.get(n);
                for(int i=0;i<vtx.nbrs.size();i++){
                    Integer nn = vtx.nbrs.get(i);
                    if(!visited.containsKey(nn)){
                        visited.put(nn,true);
                        queue.add(nn);
                    }
                }
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
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
            g.print();
            g.bfs(0);
            System.out.println();
            t--;
        }
    }
}
