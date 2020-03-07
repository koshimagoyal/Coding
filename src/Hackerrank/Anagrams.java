package Hackerrank;

import java.util.*;

public class Anagrams {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        char a[]=s1.toLowerCase().toCharArray();
        char b[]=s2.toLowerCase().toCharArray();
        int count[] = new int[256];
        int count1[] = new int[256];
        boolean flag = true;
        if(a.length!=b.length){
            flag = false;
        }else{
            for(int i=0;i<a.length;i++){
                count[a[i]]++;
                count1[b[i]]++;
            }
            for(int i=0;i<a.length;i++){
                char c = a[i];
                int no = count[a[i]];
                if(no!=count1[c]){
                    flag=false;
                    break;
                }
            }
        }
        if(flag){
            System.out.println("Anagrams");
        }else{
            System.out.println("Not Anagrams");
        }
    }
}
