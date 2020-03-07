package Hackerblocks;

import java.util.Arrays;
import java.util.Scanner;

public class WildcardPattern {
    static boolean match(String text,String pattern,int n,int m){

        if(m==0)
            return (n==0);

        boolean t[][] = new boolean[n+1][m+1];
        for (int i=0;i<n+1;i++)
            Arrays.fill(t[i],false);
        t[0][0] = true;
        for (int j=1;j<=m;j++){
            if(pattern.charAt(j-1)=='*')
                t[0][j] = t[0][j-1];
        }

        for (int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(pattern.charAt(j-1)=='*')
                    t[i][j] = t[i][j-1]||t[i-1][j];
                else if(pattern.charAt(j-1)=='?'||text.charAt(i-1)==pattern.charAt(j-1))
                    t[i][j] = t[i-1][j-1];
                else
                    t[i][j] = false;
            }
        }
        return t[n][m];
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String pattern = sc.next();
        if(match(text,pattern,text.length(),pattern.length()))
            System.out.println("1");
        else
            System.out.println("0");
    }
}
