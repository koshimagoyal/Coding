package Hackerearth;

import java.util.ArrayList;
import java.util.Scanner;

public class VowelRecognition {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            String st = sc.next();
            int count = 0;
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < st.length(); i++) {
                if(Character.toLowerCase(st.charAt(i))=='a'||Character.toLowerCase(st.charAt(i))=='e'||Character.toLowerCase(st.charAt(i))=='i'||Character.toLowerCase(st.charAt(i))=='o'||Character.toLowerCase(st.charAt(i))=='u') {
                    count+=(st.length()-i)*(i+1);
                }
            }
            System.out.println(count);
            t--;
        }
    }
}
