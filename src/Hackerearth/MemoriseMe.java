package Hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class MemoriseMe {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String str[] = br.readLine().trim().split(" ");
        int arr[]=new int[100000];
        for(int i=0;i<n;i++){
            arr[Integer.parseInt(str[i])]++;
        }
        int q = Integer.parseInt(br.readLine().trim());
        for(int i=0;i<q;i++){
            int k = Integer.parseInt(br.readLine().trim());
            if(arr[k]<=0){
                System.out.println("NOT PRESENT");
            }else{
                System.out.println(arr[k]);
            }
        }
    }
}
