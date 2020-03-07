package GeeksForGeeks;

import java.util.LinkedList;
import java.util.Scanner;

public class Closure {
    static int bfs(int src,int dest,int[][] adj,int v){
        boolean vis[] = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        vis[src]=true;
        queue.add(src);
        while(!queue.isEmpty()){
            int n = queue.poll();
            if(n==dest)
                return 1;
            for(int i=0;i<v;i++){
                if(adj[n][i]==1){
                    if(!vis[i]){
                        vis[i]=true;
                        queue.add(i);
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int v = sc.nextInt();
            int adj[][] = new int[v][v];
            for(int i=0;i<v;i++){
                for(int j=0;j<v;j++)
                    adj[i][j]=sc.nextInt();
            }
            for(int i=0;i<v;i++){
                for(int j=0;j<v;j++){
                    adj[i][j]=bfs(i,j,adj,v);
                }
            }
            for(int i=0;i<v;i++) {
                for (int j = 0; j < v; j++)
                    System.out.print(adj[i][j] + " ");
            }
            System.out.println();
            t--;
        }
    }
}
