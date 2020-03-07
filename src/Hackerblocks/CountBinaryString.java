package Hackerblocks;

import java.util.Scanner;

public class CountBinaryString {

    static int count(int n){
        int a[] = new int[n];
        int b[] = new int[n];
        a[0] = b[0] = 1;
        for(int i=1;i<n;i++){
            a[i] = a[i-1]+b[i-1];
            b[i] = a[i-1];
        }
        return a[n-1]+b[n-1];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            System.out.println(count(n));
            t--;
        }
    }
}
