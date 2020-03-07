package Hackerblocks;

import java.util.Scanner;

public class LLkReverse {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head,tail;
    int size=0;
    void add(int data){
        Node node = new Node(data);
        if(head==null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }
    void display(){
        Node tail = head;
        while (tail!=null){
            System.out.print(tail.data+" ");
            tail = tail.next;
        }
    }
    Node kReverse(Node head,int k){
        Node curr = head;
        Node prev = null;
        Node next = null;
        int count = 0;
        while (count<k&&curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next!=null){
            head.next = kReverse(next,k);
        }
        return prev;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        LLkReverse list = new LLkReverse();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        list.display();
        list.head = list.kReverse(list.head,k);
        System.out.println();
        list.display();
    }
}
