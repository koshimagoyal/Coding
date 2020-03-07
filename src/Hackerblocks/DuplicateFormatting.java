package Hackerblocks;

import java.util.Scanner;

public class DuplicateFormatting {
    static void formatting(String str,StringBuffer output,int i){
        if(str.length()==1){
            output.append(str);
            System.out.println(output);
        }else{
            char c = str.charAt(0);
            String st = str.substring(1);
            if(c==st.charAt(0)){
                String cm = "";
                cm+=c;
                cm+="*";
                output.append(cm);
            }else{
                output.append(c);
            }
            formatting(st,output,i);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuffer output = new StringBuffer();
        formatting(str,output,0);
    }
}
