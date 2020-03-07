package Hackerblocks;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    class Vertex{
        HashMap<String,Integer> nbrs = new HashMap<>();
    }
    HashMap<String,Vertex> vtces;

    int numVertex(){
        return this.vtces.size();
    }

    boolean containsVertex(String vname){
        return this.vtces.containsKey(vname);
    }

    void addVertex(String vname){
        Vertex vtx = new Vertex();
        vtces.put(vname,vtx);
    }

    int numEdges(){
        int count=0;
        ArrayList<String> keys = new ArrayList<>(vtces.keySet());
        for(String key:keys){
            Vertex vtx = vtces.get(key);
            count = count + vtx.nbrs.size();
        }
        return count/2;
    }

    boolean containsEdge(String v1,String v2){
        Vertex vtx1 = vtces.get(v1);
        Vertex vtx2 = vtces.get(v2);
        if(vtx1==null||vtx2==null||!vtx1.nbrs.containsKey(v2))
            return false;
        return true;
    }

    void addEdges(String v1,String v2,int cost){
        Vertex vtx1 = vtces.get(v1);
        Vertex vtx2 = vtces.get(v2);
        if(vtx1==null||vtx2==null||!vtx1.nbrs.containsKey(v2))
            return;
        vtx1.nbrs.put(v2,cost);
        vtx2.nbrs.put(v1,cost);
    }

    void removeEdge(String v1,String v2){
        Vertex vtx1 = vtces.get(v1);
        Vertex vtx2 = vtces.get(v2);
        if(vtx1==null||vtx2==null||!vtx1.nbrs.containsKey(v2))
            return;
        vtx1.nbrs.remove(v2);
        vtx2.nbrs.remove(v1);
    }

    void removeVertex(String vname){
        Vertex vtx = vtces.get(vname);
        ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
        for(String key:keys){
            Vertex nbrvtx = vtces.get(key);
            nbrvtx.nbrs.remove(vname);
        }
        vtces.remove(vname);
    }

    void display(){
        ArrayList<String> keys = new ArrayList<>(vtces.keySet());
        for(String key:keys){
            Vertex vtx = vtces.get(key);
            System.out.println(key+":"+vtx.nbrs);
        }
    }
}
