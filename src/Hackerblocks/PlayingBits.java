package Hackerblocks;

import java.util.Scanner;

public class PlayingBits {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int count = 0;
            for(int i=n;i<=m;i++){
                count+=Integer.bitCount(i);
            }
            System.out.println(count);
            t--;
        }
    }
}
