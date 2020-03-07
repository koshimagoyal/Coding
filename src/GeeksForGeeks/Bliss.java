package GeeksForGeeks;

import java.util.Scanner;

public class Bliss {
    static boolean isBleak(int n){
        for(int x = n - ceilLog(n);x<n;x++){
            if(x+Integer.bitCount(x)==n)
                return false;
        }
        return true;
    }
    static int ceilLog(int n){

        int count = 0;
        n--;
        while (n>0){
            n = n>>1;
            count++;
        }
        return count;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isBleak(n));
    }
}
