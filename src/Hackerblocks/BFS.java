package Hackerblocks;

import javafx.scene.transform.Scale;

import java.util.*;

public class BFS {
    private class Vertex{
        HashMap<Integer,Integer> nbrs = new HashMap<>();
    }
    HashMap<Integer,Vertex> vtces = new HashMap<>();
    void addVertex(Integer vname){
        if(vtces.containsKey(vname))
            return;
        else{
            Vertex vtx = new Vertex();
            vtces.put(vname,vtx);
        }
    }
    void addEdge(Integer v1,Integer v2,int cost){
        Vertex vtx1 = vtces.get(v1);
        Vertex vtx2 = vtces.get(v2);
        if(vtx1==null||vtx2==null||vtx1.nbrs.containsKey(v2)){
            return;
        }
        vtx1.nbrs.put(v2,cost);
        vtx2.nbrs.put(v1,cost);
    }
    public boolean containsEdge(Integer src,Integer dest){
        Vertex vtx1 = vtces.get(src);
        Vertex vtx2 = vtces.get(dest);
        if(vtx1==null||vtx2==null||!vtx1.nbrs.containsKey(dest)){
            return false;
        }
        return true;
    }
    private class Pair{
        int vname;
        int psf;
    }
    private int[] bfs(int src,int n){
        HashMap<Integer,Boolean> processed = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int distance[] = new int[n+1];
        Arrays.fill(distance,-1);
        //for(int i=1;i<=n;i++) {
            queue.addLast(src);
            distance[src] = 0;
            while (!queue.isEmpty()) {
                int rp = queue.removeFirst();
                processed.put(rp, true);
                Vertex rpvtx = vtces.get(rp);
                ArrayList<Integer> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
                for (Integer nbr : nbrs) {
                    if (!processed.containsKey(nbr)) {
                        queue.addLast(nbr);
                        processed.put(nbr,true);
                        distance[nbr] = distance[rp]+1;
                    }
                }
            }
        //}
        return distance;
    }
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t>0){
            BFS bfs = new BFS();
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i=0;i<m;i++){
                int x = sc.nextInt();
                bfs.addVertex(x);
                int y = sc.nextInt();
                bfs.addVertex(y);
                bfs.addEdge(x,y,6);
            }
            int src = sc.nextInt();
            int array[]=bfs.bfs(src,n);
            for(int i=1;i<=n;i++){
                if(i!=src&&array[i]>-1)
                    System.out.print(array[i]*6+" ");
                else if(i!=src&&array[i]==-1)
                    System.out.print(array[i]+" ");
            }
            System.out.println();
            t--;
        }
    }
}
