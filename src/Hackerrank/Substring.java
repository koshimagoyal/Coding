package Hackerrank;

import java.util.Scanner;

public class Substring {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        String sub[]=new String[s.length()];
        int k=0;
        for(int i=0;i<=s.length()-n;i++){
            sub[k]=s.substring(i,n+i);
            k++;
        }
        for(int i=0;i<k-1;i++){
            for(int j=i+1;j<k;j++){
                if(sub[i].compareTo(sub[j])>0){
                    String temp = sub[i];
                    sub[i] = sub[j];
                    sub[j] = temp;
                }
            }
        }
        System.out.println(sub[0]);
        System.out.println(sub[k-1]);
    }
}
