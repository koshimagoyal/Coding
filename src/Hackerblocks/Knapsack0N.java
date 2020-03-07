package Hackerblocks;

public class Knapsack0N {
    static int knapsackN(int W,int val[],int wt[],int n){
        int K[]=new int[W+1];
        for(int i=0;i<=W;i++){
            for(int j=0;j<n;j++){
                if(wt[j]<=i){
                    K[i] = Math.max(K[i],K[i-wt[j]]+val[j]);
                }
            }
        }
        return K[W];
    }

    public static void main(String args[]){
        int W = 100;
        int val[] = {10,30,20};
        int wt[] = {5,10,15};
        int n = val.length;
        System.out.println(knapsackN(W,val,wt,n));
    }
}
