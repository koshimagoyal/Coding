package Hackerblocks;

import java.util.Arrays;
import java.util.Scanner;

public class ExchangingCoins {
    static long dp[]=new long[1000000];
    static long exchange(long n){

        if(n<=1000000&&dp[(int)n]!=-1)
            return dp[(int)n];

        if(n<12){
            dp[(int)n]=n;
            return n;
        }
        long ans = Math.max(n,exchange(n/2)+exchange(n/3)+exchange(n/4));
        if(n<=1000000){
            dp[(int)n]=ans;
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        Arrays.fill(dp,-1);
        System.out.println(exchange(n));
    }
}
