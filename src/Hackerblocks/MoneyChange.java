package Hackerblocks;

import java.util.Scanner;

public class MoneyChange {
    static int sum(int arr[],int m,int n){
        int dp[] = new int[m+1];
        dp[0]=1;
        for(int i=1;i<=m;i++){
            dp[i]=0;
        }
        for(int i=0;i<n;i++){
            for(int j = arr[i];j<=m;j++) {
                dp[j] += dp[j - arr[i]];
            }
        }

        return dp[m];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            int m = sc.nextInt();
            System.out.println(sum(arr,m,n));
            t--;
        }
    }
}
