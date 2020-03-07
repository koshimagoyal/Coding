package Hackerblocks;

import java.util.Scanner;

public class RedundantParenthesis {

    private boolean redundant(String str) {
        Stack stack = new Stack(str.length());
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==')'){
                int count=0;
                while(stack.pop()!='(') {
                    count++;
                }
                if(count<1){
                    return true;
                }
            }else{
                stack.push(str.charAt(i));
            }
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            String str = sc.next();
            RedundantParenthesis stack = new RedundantParenthesis();
            if(stack.redundant(str)){
                System.out.println("Duplicate");
            }else{
                System.out.println("Not Duplicates");
            }
            t--;
        }
    }

}
class Stack{
    char arr[];
    int top;
    Stack(int n){
        arr = new char[n];
        top = -1;
    }
    void push(char data){
        if(!isFull()){
            arr[++top]=data;
        }
    }
    private boolean isFull() {
        if(top>=arr.length)
            return true;
        else
            return false;
    }

    char pop(){
        if(!isEmpty()){
            return arr[top--];
        }
        return '\0';
    }

    private boolean isEmpty() {
        if(top<0)
            return true;
        else
            return false;
    }
}
