package Hackerblocks;

import java.util.Scanner;

public class SanketStrings {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String str = sc.next();
        int count[]={0,0};
        int left=0,ans=0;
        for(char c:str.toCharArray()){
            count[c-'a']++;
            if(Math.min(count[0],count[1])>k){
                count[str.charAt(left)-'a']--;
                left++;
            }else{
                ans++;
            }
        }

        System.out.println(ans);
    }
}
