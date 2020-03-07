package Hackerblocks;

import java.util.Arrays;
import java.util.Scanner;

public class CountSort {
    static void count_sort(long arr[],int n){
        long extra[] = new long[1000005];
        long max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(max<arr[i]){
                max = arr[i];
            }
            extra[(int)arr[i]]++;
        }
        for(int i=0;i<=max;i++){
            for(int j=1;j<=extra[i];j++)
                System.out.print(i+" ");
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long arr[] = new long[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextLong();
        count_sort(arr,n);
    }
}
