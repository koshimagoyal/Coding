package Hackerblocks;

import java.util.Scanner;

public class LLkAppend {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head,tail;
    int size = 0;
    void add(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }
    void display(){
        tail = head;
        while(tail!=null){
            System.out.print(tail.data+" ");
            tail = tail.next;
        }
    }
    void k_append(int k){
        tail = head;
        int count = 0;
        int l = size - k;
        System.out.print(size+" "+l);
        while(count<l-1&&tail!=null){
            tail=tail.next;
            count++;
        }
        Node curr = tail.next;
        Node prev = curr;
        count=1;
        while(count!=k){
            curr=curr.next;
            count++;
        }
        tail.next = curr.next;
        curr.next = head;
        head = prev;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LLkAppend list = new LLkAppend();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        int k = sc.nextInt();
        list.display();
        System.out.println();
        list.k_append(k);
        System.out.println();
        list.display();
    }
}
