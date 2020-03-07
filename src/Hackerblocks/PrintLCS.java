package Hackerblocks;

import java.util.Scanner;

public class PrintLCS {
    static void printLCS(char[] X,char[] Y,int m,int n){
        int LCS[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0)
                    LCS[i][j]=0;
                else if(X[i-1]==Y[j-1])
                    LCS[i][j]=LCS[i-1][j-1]+1;
                else
                    LCS[i][j]=Math.max(LCS[i-1][j],LCS[i][j-1]);
            }
        }
        int index = LCS[m][n];
        int temp = index;

        char[] lcs = new char[index+1];
        lcs[index]='\0';
        int i=m,j=n;
        while (i>0&&j>0){
            if(X[i-1]==Y[j-1]){
                lcs[index-1]=X[i-1];
                i--;
                j--;
                index--;
            }
            else if(LCS[i-1][j]>LCS[i][j-1])
                i--;
            else
                j--;
        }
        for (int k=0;k<temp;k++){
            System.out.print(lcs[k]);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String str2 = sc.next();
        printLCS(str.toCharArray(),str2.toCharArray(),str.length(),str2.length());

    }
}
