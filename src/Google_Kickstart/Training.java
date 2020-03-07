package Google_Kickstart;

import java.util.*;
public class Training{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int j=1;j<=t;j++){
            int n = sc.nextInt();
            int p = sc.nextInt();
            int arr[] = new int[n];
            int k=0,max = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                if(k<p){
                    if(max<arr[i])
                        max = arr[i];
                    k++;
                }
            }
            int hours = 0;
            for(int i=0;i<p;i++){
                if(arr[i]<max){
                    hours+=(max-arr[i]);
                }
            }
            System.out.println("Case #"+j+": "+hours);
        }
    }
}
