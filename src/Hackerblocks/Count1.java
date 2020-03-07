package Hackerblocks;

import java.util.Scanner;

public class Count1 {
    static void longest(int a[],int n,int k){
        int l =0,r=0,z=0;
        int ml=0,bestl=0;
        while(r<n){
            if(a[r]==1){
                r++;
            }else if(a[r]==0){
                z++;
                r++;
            }
            while(z>k){
                if(a[l]==0){
                    z--;
                    l++;
                }else if(a[l]==1){
                    l++;
                }
            }
            if(ml<(r-l)){
                ml = r-l;
                bestl = l;
            }
        }
        System.out.println(ml);
        for(int i=bestl;i<bestl+ml;i++){
            a[i] = 1;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        longest(arr,n,k);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
