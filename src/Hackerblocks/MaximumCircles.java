package Hackerblocks;

import java.util.*;

public class MaximumCircles {
    static class Circle{
        long start;
        long end;
        Circle(long start,long end){
            this.start = start;
            this.end = end;
        }
    }

    static ArrayList<Circle> circle;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        circle = new ArrayList<>();
        for(int i=0;i<n;i++){
            long c = sc.nextLong();
            long r = sc.nextLong();
            Circle circles = new Circle(c-r,c+r);
            circle.add(circles);
        }
        Collections.sort(circle, new Comparator<Circle>() {
            @Override
            public int compare(Circle o1, Circle o2) {
                Long v1 = o1.end;
                Long v2 = o2.end;
                return v1.compareTo(v2);
            }
        });
        long val = circle.get(0).end;
        long count = 1;
        for(int i=1;i<n;i++){
            if(circle.get(i).start>=val){
                val = circle.get(i).end;
                count++;
            }
        }
        System.out.println(n-count);
    }
}
