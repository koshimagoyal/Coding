package GeeksForGeeks;

import java.util.Scanner;

public class KadaneAlgo {
    static int kadane(int arr[],int n){
        int max=0;
        int max_so_far = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max +=arr[i];
            if(max<0)
                max=0;
            else{
                if(max>max_so_far)
                    max_so_far = max;
            }
        }
        return max_so_far;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(kadane(arr,n));
    }
}
