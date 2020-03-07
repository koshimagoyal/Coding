package Hackerearth;

import java.util.Scanner;

public class RemoveFriends {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    private Node head,tail;
    private void add(int data){
        Node node = new Node(data);
        if(head==null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = tail.next;
        }
    }
    private void remove(){
        Node prev = null;
        Node curr = head;
        Node next = head.next;
        boolean flag = false;
        while (next!=null){
            if(curr.data<next.data){
                if(curr.data==head.data){
                    flag = true;
                    removeStart();
                    curr = head;
                    break;
                }else{
                    flag = true;
                    prev.next = next;
                    curr = prev;
                    break;
                }
            }else{
                prev = curr;
                curr = curr.next;
            }
            next = next.next;
        }
        if(!flag){
            removeLast();
        }
    }
    private void removeLast() {
        Node curr = head;
        while (curr.next!=null){
            curr=curr.next;
        }
        curr.next = null;
    }

    private void removeStart() {
        head = head.next;
    }

    private void display(){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            RemoveFriends list = new RemoveFriends();
            for(int i=0;i<n;i++){
                list.add(sc.nextInt());
            }
            for(int i=0;i<k;i++) {
                list.remove();
            }
            list.display();
            System.out.println();
            t--;
        }
    }
}
