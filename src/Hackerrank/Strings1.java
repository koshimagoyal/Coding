package Hackerrank;

import java.util.Scanner;

public class Strings1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(a.length()+b.length());
        if(a.compareTo(b)>0){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        StringBuffer s1 = new StringBuffer(a);
        s1.replace(0,1,Character.toString(Character.toUpperCase(a.charAt(0))));
        StringBuffer s2 = new StringBuffer(b);
        s2.replace(0,1,Character.toString(Character.toUpperCase(b.charAt(0))));
        System.out.println(s1+" "+s2);
    }
}
