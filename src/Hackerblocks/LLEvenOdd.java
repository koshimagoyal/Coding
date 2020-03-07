package Hackerblocks;

import java.util.Scanner;

public class LLEvenOdd {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head,tail;
    void add(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = tail.next;
        }
    }
    void display(){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    void evenOdd(){
        Node even = null;
        Node even_next = null;
        Node odd = null;
        Node odd_next = null;
        Node curr = head;
        while(curr!=null){
            if(curr.data%2==0){
                if(even==null){
                    even = curr;
                    even_next = curr;
                }else{
                    even_next.next = curr;
                    even_next = even_next.next;
                }
            }else{
                if(odd==null){
                    odd = curr;
                    odd_next = curr;
                }else{
                    odd_next.next = curr;
                    odd_next = odd_next.next;
                }
            }
            curr = curr.next;
        }
        if(even!=null&&odd!=null){
            odd_next.next = even;
            even_next.next = null;
            head = odd;
        }else if(even==null){
            head = odd;
            odd_next.next = null;
        }else{
            head = even;
            even_next.next = null;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LLEvenOdd list = new LLEvenOdd();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        list.display();
        list.evenOdd();
        System.out.println();
        list.display();
    }
}
