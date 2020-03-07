package Hackerblocks;

import java.util.Scanner;

public class EggDropping {
    static int drop(int n,int k){
        int floor[][]=new int[n+1][k+1];
        int res;
        int i,j,x;
        //floor 0 or 1
        for(i=1;i<=n;i++){
            floor[i][1]=1;
            floor[i][0]=0;
        }
        //egg 0 or 1
        for(j=1;j<=k;j++){
            floor[1][j]=j;
        }
        for(i=2;i<=n;i++){
            for(j=2;j<=k;j++){
                floor[i][j] = Integer.MAX_VALUE;
                for (x=1;x<=j;x++){
                    res = 1+Math.max(floor[i-1][x-1],floor[i][j-x]);
                    if(res<floor[i][j])
                        floor[i][j]=res;
                }
            }
        }
        return floor[n][k];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(drop(k,n));
            t--;
        }
    }
}
