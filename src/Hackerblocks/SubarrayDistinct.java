package Hackerblocks;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SubarrayDistinct {
    static long sum(long arr[],int n){
        HashSet<Long> s = new HashSet<>();
        int j=0;
        long ans=0;
        for(int i=0;i<n;i++){
            while(j<n&&!s.contains(arr[j])){
                s.add(arr[j]);
                j++;
            }
            ans+=((j-i)*(j-i+1))/2;
            s.remove(arr[i]);
        }
        return ans%1000000007;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long arr[] = new long[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLong();
        }
        System.out.println(sum(arr,n));
    }
}
