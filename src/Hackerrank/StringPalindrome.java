package Hackerrank;

import java.util.Scanner;

public class StringPalindrome {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        StringBuffer s2 = new StringBuffer(s1);
        s2.reverse();
        if(s1.equals(s2.toString())){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
