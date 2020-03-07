package Hackerblocks;

import java.util.Scanner;

public class BookAllocation {

    static boolean isValidConfig(long arr[],int n,int k,long ans){
        int students = 1;
        long current_pages = 0;
        for(int i=0;i<n;i++){
            if(current_pages+arr[i]>ans){
                current_pages = arr[i];
                students++;
                if(students>k)
                    return false;
            }else{
                current_pages += arr[i];
            }
        }
        return true;
    }
    static long bookAllocation(long arr[],int n,int k){

        long total_pages = 0,start=0,end=0;
        for(int i=0;i<n;i++){
            total_pages+=arr[i];
            start = Math.max(start,arr[i]);
        }
        end = total_pages;
        long final_ans = 0;
        while(start<=end){
            long mid = (start+end)/2;
            if(isValidConfig(arr,n,k,mid)){
                //left part
                final_ans = mid;
                end = mid - 1;
            }else{
                //right part
                start = mid + 1;
            }
        }
        return final_ans;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            long arr[] = new long[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextLong();
            }
            System.out.println(bookAllocation(arr,n,m));
            t--;
        }
    }
}
