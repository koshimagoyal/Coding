package Hackerblocks;

import java.util.Scanner;

public class DeepakJourney {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t>0){
            int n = sc.nextInt();
            long cost[] = new long[n];
            long l[] = new long[n];
            for(int i=0;i<n;i++){
                cost[i] = sc.nextLong();
            }
            for(int i=0;i<n;i++){
                l[i] = sc.nextLong();
            }
            long ans=0,money=Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                if(cost[i]<money){
                    money = cost[i];
                    ans+=(money*l[i]);
                }else{
                    ans+=(money*l[i]);
                }
            }
            System.out.println(ans);
            t--;
        }
    }
}
