package Hackerblocks;

import java.util.*;

public class SumItUp {
    static void sumIt(int arr[],int idx,int target,ArrayList<Integer> curr,ArrayList<ArrayList<Integer>> res){

        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(i==idx||arr[i]!=arr[i-1]){
                curr.add(arr[i]);
                sumIt(arr,i+1,target-arr[i],curr,res);
                curr.remove(curr.size()-1);
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int sum = sc.nextInt();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        sumIt(arr,0,sum,new ArrayList<>(),res);

        for(ArrayList<Integer> help:res){
            for(int val:help){
                System.out.print(val+" ");
            }
            System.out.println();
        }

    }
}
