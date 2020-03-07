package Hackerblocks;

import java.util.Scanner;

public class KthRoot {
    static double kthRoot(long n,long k){

        double xPre = Math.random()%10;
        double eps = 0.001;
        double delX = Integer.MAX_VALUE;
        double xK = 0.0;
        while(delX>eps){
            xK = ((k-1.0)*xPre+(double)n/Math.pow(xPre,k-1))/(double)k;
            delX = Math.abs(xK-xPre);
            xPre = xK;
        }
        return xK;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        double ans = kthRoot(n,k);
        System.out.println((int)ans);
    }
}
