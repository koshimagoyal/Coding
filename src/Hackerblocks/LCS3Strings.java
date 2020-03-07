package Hackerblocks;

import java.util.Scanner;

public class LCS3Strings {
    static int lcs(String x,String y,String z,int m,int n,int o){

        int l[][][]=new int[m+1][n+1][o+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k<=o;k++){
                    if(i==0||j==0||k==0)
                        l[i][j][k]=0;
                    else if(x.charAt(i-1)==y.charAt(j-1)&&x.charAt(i-1)==z.charAt(k-1))
                        l[i][j][k]=l[i-1][j-1][k-1]+1;
                    else
                        l[i][j][k]=Math.max(Math.max(l[i-1][j][k],l[i][j-1][k]),l[i][j][k-1]);
                }
            }
        }
        return l[m][n][o];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String s3 = sc.next();
        System.out.println(lcs(s1,s2,s3,s1.length(),s2.length(),s3.length()));
    }
}
