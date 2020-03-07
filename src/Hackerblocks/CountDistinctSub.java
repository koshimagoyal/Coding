package Hackerblocks;

import java.util.Arrays;
import java.util.Scanner;

public class CountDistinctSub {
    static final int MAX = 256;

    static int count(String str){
        int[] last = new int[MAX];
        Arrays.fill(last,-1);
        int n = str.length();
        int[]dp = new int[n+1];
        dp[0]=1;
        for (int i=1;i<=n;i++){
            dp[i]=2*dp[i-1];
            if(last[(int)str.charAt(i-1)]!=-1)
                dp[i]=dp[i]-dp[last[(int)str.charAt(i-1)]];
            last[(int)str.charAt(i-1)] = (i-1);
        }

        for(int i=0;i<=n;i++){
            System.out.println(dp[i]);
        }
        return dp[n];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            String str = sc.next();
            System.out.println(count(str));
            t--;
        }
    }
}
