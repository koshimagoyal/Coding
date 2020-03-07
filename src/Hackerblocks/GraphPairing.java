package Hackerblocks;

import java.util.*;

public class GraphPairing {
    class Vertex{
        HashMap<Integer,Integer> nbrs = new HashMap<>();
    }
    HashMap<Integer,Vertex> vtces = new HashMap<>();
    void addVertex(int vname){
        if(vtces.containsKey(vname))
            return;
        Vertex vtx = new Vertex();
        vtces.put(vname,vtx);
    }
    void addEdge(int v1,int v2,int cost){
        Vertex vtx1 = vtces.get(v1);
        Vertex vtx2 = vtces.get(v2);
        if(vtx1==null||vtx2==null||vtx1.nbrs.containsKey(v2))
            return;
        vtx1.nbrs.put(v2,cost);
        vtx2.nbrs.put(v1,cost);
    }

    private void DFSUtil(int v,HashMap<Integer,Boolean> processed,int count){
        processed.put(v,true);
        count++;
        for(Integer nbr : vtces.get(v).nbrs.keySet()){
            if(!processed.get(nbr)){
                DFSUtil(nbr,processed,count);
            }
        }
    }
    private int connectedComponents(int src,int n){
        HashMap<Integer,Boolean> processed = new HashMap<>();
        for(Integer v:vtces.keySet()){
            processed.put(v,false);
        }
        int city_size=0,total_ways=0;
        total_ways=(n*(n-1))/2;
        DFSUtil(src,processed,city_size);
        total_ways-=(city_size*(city_size-1))/2;
        for(Integer v:vtces.keySet()){
            if(!processed.get(v)){
                DFSUtil(v,processed,city_size);
            }
            total_ways-=(city_size*(city_size-1))/2;
        }
        return total_ways;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        GraphPairing pair = new GraphPairing();
        for(int i=0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            pair.addVertex(x);
            pair.addVertex(y);
            pair.addEdge(x,y,0);
        }
        if(m==1){
            System.out.println((n*(n-1)/2)-1);
        }else {
            System.out.println(pair.connectedComponents(0,n));
        }
    }
}
