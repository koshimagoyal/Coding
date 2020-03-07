package Hackerblocks;

import java.util.*;
import java.util.Stack;

public class BeautifulVertices {

    class Vertex{
        HashMap<Integer,Integer> nbrs = new HashMap<>();
    }
    HashMap<Integer,Vertex> vtcs=new HashMap<>();

    void addVertex(Integer vname){
        if (vtcs.containsKey(vname))
            return;
        Vertex vtx = new Vertex();
        vtcs.put(vname,vtx);
    }

    void addEdge(Integer v1,Integer v2){
        Vertex vtx1 = vtcs.get(v1);
        Vertex vtx2 = vtcs.get(v2);
        if (vtx1==null||vtx2==null||vtx1.nbrs.containsKey(v2))
            return;
        vtx1.nbrs.put(v2,0);
    }

    class Node{
        boolean visited = false;
        int myChildren = 0;
        Node parent = null;
        //ArrayList<Node> adj = new ArrayList<>();

        /*public void addNode(Node a) {
            adj.add(a);
        }*/
    }
    private int beautifulVertices(int n){
        int sum=0;
        Node node[] = new Node[n+1];
        for(int i=1;i<=n;i++){
            if(vtcs.containsKey(i)){
                node[i].visited = true;
                if(!vtcs.get(i).nbrs.isEmpty()){
                    node[i].myChildren = vtcs.get(i).nbrs.size();
                    for(int nbr:vtcs.get(i).nbrs.keySet()){
                        node[nbr].parent = node[i];
                    }
                }
            }
        }
        for(int i=1;i<=n;i++) {
            if (node[i].myChildren > node[i].parent.myChildren) {
                sum++;
            }
        }
        return sum;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        BeautifulVertices bv = new BeautifulVertices();
        for(int i=0;i<m;i++){
            Integer v1 = sc.nextInt();
            bv.addVertex(v1);
            Integer v2 = sc.nextInt();
            bv.addVertex(v2);
            bv.addEdge(v1,v2);
        }
        System.out.println(bv.beautifulVertices(n));
    }
}
