package GeeksForGeeks;

import java.util.*;

class Vertexx{
    HashMap<Integer,Integer> nbrs = new HashMap<>();
}
class Graphh{
    private HashMap<Integer,Vertexx> vtcs;
    Graphh(){
        vtcs = new HashMap<>();
    }
    void addVertex(Integer vname){
        if(vtcs.containsKey(vname))
            return;
        else{
            Vertexx vtx = new Vertexx();
            vtcs.put(vname,vtx);
        }
    }
    void addEdge(Integer src,Integer dest,int cost){
        Vertexx vtx1 = vtcs.get(src);
        Vertexx vtx2 = vtcs.get(dest);
        if(vtx1==null||vtx2==null||vtx1.nbrs.containsKey(dest))
            return;
        else
            vtx1.nbrs.put(dest,cost);
    }
    boolean containsEdge(Integer n,Integer dest){
        Vertexx vtx1 = vtcs.get(n);
        Vertexx vtx2 = vtcs.get(dest);
        if(vtx1==null||vtx2==null||!vtx1.nbrs.containsKey(dest))
            return false;
        else
            return true;
    }
    int bfs(int src,int dest){
        HashMap<Integer,Boolean> visited = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);
        int cost = 0;
        while(!queue.isEmpty()){
            Integer n = queue.poll();
            visited.put(n,true);
            if(containsEdge(n,dest)){
                return cost+vtcs.get(n).nbrs.get(dest);
            }
            Vertexx rp = vtcs.get(n);
            for(Map.Entry<Integer,Integer> entry:rp.nbrs.entrySet()){
                Integer hh = entry.getKey();
                if(!visited.containsKey(hh)){
                    cost+=entry.getValue();
                    //System.out.println(cost+" key"+hh+" cost"+entry.getValue());
                    queue.add(hh);
                }
            }
        }
        return cost;
    }
}
public class ShortestPath {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            Graphh g = new Graphh();
            for(int i=1;i<=n;i++){
                g.addVertex(i);
                if(i+1<=n) {
                    g.addVertex(i+1);
                    g.addEdge(i, i + 1, 1);
                }
                if(3*i<=n) {
                    g.addVertex(3*i);
                    g.addEdge(i, 3 * i, 1);
                }
            }
            System.out.println(g.bfs(1,n));
            t--;
        }
    }
}
