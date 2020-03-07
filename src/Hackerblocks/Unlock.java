package Hackerblocks;

import java.util.HashMap;
import java.util.Scanner;

public class Unlock {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            map.put(arr[i],i);
        }
        for(int i=0;i<n;i++){
            if(k<=0)
                break;
            if(arr[i]==n-i){
                continue;
            }else{
                int h = n - i;
                int pos = map.get(h);
                map.put(arr[i],pos);
                map.put(arr[pos],i);
                int temp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = temp;
                k--;
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
