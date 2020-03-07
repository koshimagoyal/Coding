package Hackerblocks;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class MinMoneyNeed {
    static int knapSack(int W,ArrayList<Integer> wt,ArrayList<Integer> val,int n){
        int i,w;
        int K[][] = new int[n+1][W+1];
        for (i=0;i<=W;i++)
            K[0][i]=10000000;
        for (i=1;i<=n;i++)
            K[i][0]=0;
        for(i=1;i<=n;i++){
            for(w=1;w<=W;w++){
                if(wt.get(i-1)<=w)
                    K[i][w]=Math.min(val.get(i-1)+K[i][w-wt.get(i-1)],K[i-1][w]);
                else
                    K[i][w]=K[i-1][w];
            }
        }
        return (K[n][W]==10000000)?-1:K[n][W];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        ArrayList<Integer> wt = new ArrayList<>();
        int cost[] = new int[W];
        for(int i=0;i<W;i++)
            cost[i]=sc.nextInt();
        ArrayList<Integer> val=new ArrayList<>();
        int size=0;
        for(int i=0;i<W;i++){
            if(cost[i]!=-1){
                val.add(cost[i]);
                wt.add(i+1);
                size++;
            }
        }
        System.out.println(knapSack(W,wt,val,size));
    }
}
