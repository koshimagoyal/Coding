package Hackerblocks;

import java.util.Scanner;

public class KorderedLCS {
    static int kLCS(int[] x,int[] y,int m,int n,int k){
        int l[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0||k==0)
                    l[i][j]=0;
                else if(x[i-1]==y[j-1])
                    l[i][j] = l[i-1][j-1]+1;
                else
                    l[i][j]= Math.max(l[i-1][j],l[i][j-1]);
            }
        }
        int change = Math.min(Math.min(m,n)-l[m][n],k);
        return change+l[m][n];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x[]=new int[m+1];
        for(int i=0;i<m;i++)
            x[i]=sc.nextInt();
        int y[]=new int[n+1];
        for(int j=0;j<n;j++)
            y[j]=sc.nextInt();
        System.out.println(kLCS(x,y,m,n,k));
    }
}
