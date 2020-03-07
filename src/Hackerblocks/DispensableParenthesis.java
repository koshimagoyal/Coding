package Hackerblocks;

import java.util.Scanner;

public class DispensableParenthesis {
    class Stack {
        char arr[];
        int top, size;

        Stack(int n) {
            arr = new char[n];
            top = -1;
            size = n;
        }

        private boolean isFull() {
            if (top >= size) {
                return true;
            } else {
                return false;
            }
        }

        private boolean isEmpty() {
            if (top == -1) {
                return true;
            } else {
                return false;
            }
        }

        private char top() {
            return arr[top];
        }

        private void push(char data) {
            if (!isFull()) {
                arr[++top] = data;
            }
        }

        private char pop() {
            if (!isEmpty()) {
                return arr[top--];
            }
            return '\0';
        }
    }
    boolean findRedundant(String str){
        Stack stack = new Stack(str.length());
        char[]s = str.toCharArray();
        for (char ch:s){
            if(ch==')'){
                char top = stack.top();
                stack.pop();
                int elements = 0;
                while (top!='('){
                    elements++;
                    top = stack.top();
                    stack.pop();
                }
                if(elements<1)
                    return true;
            }else {
                stack.push(ch);
            }
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            String str = sc.next();
            DispensableParenthesis obj = new DispensableParenthesis();
            if(obj.findRedundant(str)){
                System.out.println("Duplicates");
            }else{
                System.out.println("Not Duplicates");
            }
            t--;
        }
    }
}
