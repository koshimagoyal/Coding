package Hackerblocks;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Median {
    static void printMedian(int arr[]){
        int med = arr[0];
        PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> greater = new PriorityQueue<>();
        smaller.add(arr[0]);
        System.out.print(med+" ");
        for(int i=1;i<arr.length;i++){
            int x = arr[i];
            if(smaller.size()>greater.size()){
                if(x<med){
                    greater.add(smaller.remove());
                    smaller.add(x);
                }else{
                    greater.add(x);
                }
                med = (int)((smaller.peek()+greater.peek())/2);
            }else if(smaller.size()==greater.size()){
                if(x<med){
                    smaller.add(x);
                    med = smaller.peek();
                }else{
                    greater.add(x);
                    med = greater.peek();
                }
            }else{
                if(x<med){
                    smaller.add(x);
                }else{
                    smaller.add(greater.remove());
                    greater.add(x);
                }
                med = (int)((smaller.peek()+greater.peek())/2);
            }
            System.out.print(med+" ");
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int []arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            printMedian(arr);
            System.out.println();
            t--;
        }
    }
}
