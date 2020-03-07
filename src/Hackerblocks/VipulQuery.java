package Hackerblocks;

import java.util.Scanner;

public class VipulQuery {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String arr[] = new String[n];
        int red_arr[] = new int[n];
        int blue_arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.next();
            String str = arr[i];
            int red_count=0,blue_count=0;
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)=='R'){
                    red_count++;
                }else{
                    blue_count++;
                }
            }
            red_arr[i]=red_count;
            blue_arr[i]=blue_count;
        }
        int t = sc.nextInt();
        while(t>0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int line_count = 0;
            for(int i=0;i<n;i++){
                if(x<0&&y<0){
                    break;
                }else if(x-blue_arr[i]>=0&&y-red_arr[i]>=0){
                    x-=blue_arr[i];
                    y-=red_arr[i];
                    line_count++;
                }
            }
            System.out.print(line_count);
            t--;
        }
    }
}
