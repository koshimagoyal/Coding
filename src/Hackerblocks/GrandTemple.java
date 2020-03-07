package Hackerblocks;

import java.util.*;

public class GrandTemple {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x[] = new int[n];
        int y[] = new int[n];
        for(int i=0;i<n;i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        Arrays.sort(x);
        Arrays.sort(y);
        long dx=0,dy=0;
        for(int i=1;i<n;i++){
            dx = Math.max(dx,x[i]-x[i-1]);
            dy = Math.max(dy,y[i]-y[i-1]);
        }
        System.out.println((dx-1)*(dy-1));
    }
}
