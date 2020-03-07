package Hackerblocks;

import java.util.ArrayList;
import java.util.Scanner;

public class GenerateParenthesis {
    static ArrayList<String> list = new ArrayList<>();

    static void generateParenthesis(int idx, int open, int close, int n, char[] output) {
        //base
        if (idx == 2 * n) {
            output[idx] = '\0';
            String str = new String(output);
            //System.out.print(str);
            list.add(str);
            return;
        }
        //recursive
        if (open < n) {
            output[idx] = '(';
            generateParenthesis(idx + 1, open + 1, close, n, output);
            output[idx] = '\0';
        }

        if (close < open) {
            output[idx] = ')';
            generateParenthesis(idx + 1, open, close + 1, n, output);
            output[idx] = '\0';
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] output = new char[100];
        generateParenthesis(0, 0, 0, n, output);
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }

    }
}