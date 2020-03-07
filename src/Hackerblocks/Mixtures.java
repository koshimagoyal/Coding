package Hackerblocks;

import java.util.Scanner;

public class Mixtures {
    static long dp[][] = new long[1000][1000];
    static int arr[] = new int[1000];
    static long sum(int s,int e){
        long ans =0;
        for(int i=s;i<=e;i++){
            ans+=arr[i];
            ans%=100;
        }
        return ans;
    }
    static long mixture(int i,int j){
        if(i>=j)
            return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            dp[i][j] = Math.min(dp[i][j],mixture(i,k)+mixture(k+1,j)+sum(i,k)*sum(k+1,j));
        }
        return dp[i][j];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(mixture(0,n-1));
    }
}
