package Hackerrank;

import java.util.Scanner;

public class StaticInteger {
    static Scanner sc = new Scanner(System.in);
    static int B = sc.nextInt();
    static int H = sc.nextInt();
    static boolean flag;
    static{
        if(B<0||H<0){
            flag = false;
            System.out.println("false");
        }else{
            flag = true;
        }
    }
    public static void main(String args[]){
        if(flag){
            int area = B*H;
            System.out.println(area);
        }
    }
}
