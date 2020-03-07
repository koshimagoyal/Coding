package Hackerblocks;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HotelVisit {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());
        int query = sc.nextInt();
        int k = sc.nextInt();
        int count=1;
        while(query>0){
            int type = sc.nextInt();
            long ans = 0;
            if(type==1){
                int x = sc.nextInt();
                int y = sc.nextInt();
                ans = (x*x)+(y*y);
                if(count<=k){
                    queue.add(ans);
                    count++;
                }else if(ans<queue.peek()){
                    queue.remove();
                    queue.add(ans);
                }
            }else if(type==2){
                System.out.println(queue.peek());
            }
            query--;
        }
    }

}
