package Hackerblocks;

import java.util.Arrays;
import java.util.Scanner;

public class BracketsAllOver {
    private static int pre=0,bef=0;
    private static long solve(int p, int open, int take,int L){
        int dp[][][] = new int[2222][2222][2];
        for(int [][] i:dp){
            for(int[] j:i){
                Arrays.fill(j,0);
            }
        }
        if (p == L) {
            boolean val;
            if(take==1){
                val = true;
            }else{
                val = false;
            }
            val = val&&(open==0);
            if(!val)
                return 0;
            else
                return 1;
        }
        long ret = dp[p][open][take];
        if (ret != -1)return ret;
        ret = 0;
        if (take==0){
            if (open >= pre)
                ret = (ret + solve(p + 1, open - pre +bef, 1,L)) % 1000000007;
        }
        ret = (ret + solve(p + 1, open +1, take,L)) % 1000000007;
        if(open==1)
            ret = (ret + solve(p + 1, open - 1, take,L)) % 1000000007;
        return ret;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int L = n-m+1;
        String ss = sc.next();
        if(n%2==1) {
            System.out.println(0);
        }
        int x =0;
        for(int i=0;i<m;i++){
            if(ss.charAt(i)=='(')
                x++;
            else
                x--;
            if(x<0) {
                pre++;
            }
            x++;
        }
        bef = x;
        System.out.println(solve(0,0,0,L));
    }
}
