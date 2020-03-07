import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
    static int edit(String str1,String str2,int n,int m){
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0)
                    dp[i][j]=j;
                else if(j==0)
                    dp[i][j]=i;
                else if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
            }
        }
        return dp[m][n];
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while(sc.hasNext()){
            String str = sc.next();
            if(str!="END"){
                list.add(str);
            }else{
                break;
            }
        }
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(edit(str1,str2,str1.length(),str2.length()));
    }
}
