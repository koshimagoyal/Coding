package Hackerblocks;

import java.util.Scanner;

public class KeypadCodes {
    static int count=0;
    static void keypad(String keypad[],String n,StringBuffer output,int i,int j){
        if(i==n.length()){
            System.out.print(output+" ");
            count++;
        }else{
            int index = n.charAt(i)-'0';
            for(int k=0;k<keypad[index-1].length();k++){
                output.setCharAt(j,keypad[index-1].charAt(k));
                keypad(keypad,n,output,i+1,j+1);
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        String keypad[] = {"abc","def","ghi","jkl","mno","pqrs","tuv","wx","yz"};
        StringBuffer output = new StringBuffer(n);
        keypad(keypad,n,output,0,0);
        System.out.println();
        System.out.print(count);
    }
}
