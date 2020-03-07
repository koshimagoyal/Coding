package GeeksForGeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AssignmentProblem {
    static class Vertex{
        ArrayList<Integer> nbrs = new ArrayList<>();
    }
    static class Graph{
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
            if(vtx1==null||vtx2==null)
                return;
            else
                vtx1.nbrs.add(dest);
        }
        int assignment(){
            int sum=0;
            for(Map.Entry<Integer,Vertex> entry:vtcs.entrySet()){
                if (entry.getValue().nbrs.size()!=0) {
                    ArrayList<Integer> adj = entry.getValue().nbrs;
                    int min=Integer.MAX_VALUE;
                    for (int i=0;i<adj.size();i++){
                        if(min>adj.get(i)) {
                            min = adj.get(i);
                        }
                    }
                    sum+=min;
                }
            }
            return sum;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            Graph g = new Graph();
            for(int i=0;i<n;i++){
                int src = 0;
                for(int j=0;j<n;j++){
                    int dest = sc.nextInt();
                    g.addVertex(src);
                    g.addVertex(dest);
                    g.addEdge(src,dest);
                    src++;
                }
            }
            System.out.println(g.assignment());
            t--;
        }
    }
}
