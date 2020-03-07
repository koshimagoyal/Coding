package Hackerblocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ExistOrNot {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            HashMap<Long,Long> list = new HashMap<>();
            for(int i=0;i<n;i++){
                long k = sc.nextLong();
                if(list.containsKey(k)){
                    long val = list.get(k);
                    list.put(k,val+1);
                }else{
                    long val = 1;
                    list.put(k,val);
                }
            }
            int q = sc.nextInt();
            for(int i=0;i<q;i++){
                long k = sc.nextLong();
                if(list.containsKey(k)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
            t--;
        }
    }
}
