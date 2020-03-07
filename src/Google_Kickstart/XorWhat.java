package Google_Kickstart;

import java.util.Scanner;

public class XorWhat {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int j=1;j<=t;j++){
            int n = sc.nextInt();
            int q = sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            System.out.print("Case #"+j+": ");
            while(q>0){
                int position = sc.nextInt();
                int set = sc.nextInt();
                arr[position] = set;
                int ans = arr[0];
                int max = 0,ans1;
                for(int i=1;i<n;i++){
                    ans= ans^arr[i];
                    ans1 = Integer.bitCount(ans);
                    if(ans1%2==0&&max<i+1)
                        max = i+1;
                }
                System.out.print(max+" ");
                q--;
            }
            System.out.println();
        }
    }
}
