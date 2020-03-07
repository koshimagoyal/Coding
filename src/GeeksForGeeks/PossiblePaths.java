package GeeksForGeeks;

import java.util.Arrays;
import java.util.Scanner;

public class PossiblePaths {
    static int count_path=0;
    static void dfs(int src,int dest,boolean vis[],int count_edge,int no_edge,int adj[][]){
        vis[src]=true;
        if(src==dest&&count_edge==no_edge){
            count_path+=1;
        }
        count_edge+=1;
        for(int i=0;i<adj[src].length;i++){
            if(adj[src][i]==1){
                if(!vis[i]){
                    vis[i]=true;
                    dfs(i,dest,vis,count_edge,no_edge,adj);
                }
            }
        }
        //count_edge=0;
        vis[src]=false;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t>0){
            int v = sc.nextInt();
            int adj[][] = new int[v][v];
            for(int i=0;i<v;i++){
                for(int j=0;j<v;j++)
                    adj[i][j]=sc.nextInt();
            }
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int no_edge = sc.nextInt();
            boolean vis[] = new boolean[v];
            Arrays.fill(vis,false);
            dfs(src,dest,vis,0,no_edge,adj);
            System.out.println(count_path);
            t--;
        }
    }
}
