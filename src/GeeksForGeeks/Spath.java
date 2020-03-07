package GeeksForGeeks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
class Vertex{
    HashSet<Integer> nbrs = new HashSet<>();
}
class Graph{
    HashMap<Integer,Vertex> vtcs = new HashMap<>();
    void addVertix(Integer vname){
        if(vtcs.containsKey(vname))
            return;
        else {
            Vertex vtx = new Vertex();
            vtcs.put(vname, vtx);
        }
    }
    void addEdge(Integer src,Integer dest){
        Vertex vtx1 = vtcs.get(src);
        Vertex vtx2 = vtcs.get(dest);
        if(vtx1==null||vtx2==null||vtx1.nbrs.contains(dest)){
            return;
        }
        vtx1.nbrs.add(dest);
    }
    int getDependency(){
        int sum =0;
        for(Map.Entry<Integer,Vertex> entry:vtcs.entrySet()){
            Vertex vtx = entry.getValue();
            sum+=vtx.nbrs.size();
        }
        return sum;
    }
}
public class Spath {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int v_size = sc.nextInt();
            int e_size = sc.nextInt();
            Graph g = new Graph();
            for(int i=0;i<e_size;i++){
                int src = sc.nextInt();
                g.addVertix(src);
                int dest = sc.nextInt();
                g.addVertix(dest);
                g.addEdge(src,dest);
            }
            System.out.println(g.getDependency());
            t--;
        }
    }
}
