package Hackerearth;

import java.util.Scanner;

public class ReverseLinkedlist {
    class Node{
        Object data;
        Node next;
        Node(Object data){
            this.data = data;
            next = null;
        }
    }
    private Node head,tail;
    void add(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }
    Node reverse(Node start){
        Node current = start;
        Node next;
        Node prev = null;
        while (current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    private void reverseLL(){
        Node current = head;
        Node prev = null;
        Node pre;
        while (current!=null){
            if((int)current.data%2!=0){
                prev = current;
                current = current.next;
            }else{
                pre = current;
                while(current.next!=null&&(int)current.next.data%2==0){
                    current = current.next;
                }
                Node next = current.next;
                current.next = null;
                if(prev!=null){
                    prev.next = reverse(pre);
                }else{
                    head = reverse(pre);
                }
                while(current.data!=pre.data){
                    current = current.next;
                }
                current.next = next;
                current = current.next;
            }
        }
    }
    void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ReverseLinkedlist list = new ReverseLinkedlist();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        list.reverseLL();
        list.print();
    }
}
