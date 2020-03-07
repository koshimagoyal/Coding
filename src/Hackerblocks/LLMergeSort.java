package Hackerblocks;

import java.util.Scanner;

public class LLMergeSort {
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
        tail = head;
        while(tail!=null){
            System.out.print(tail.data+" ");
            tail = tail.next;
        }
    }
    Node mergeSort(Node node){
        if(node == null||node.next == null)
            return node;

        Node middle = getMiddle(node);
        Node next_middle = middle.next;
        middle.next = null;
        Node left = mergeSort(node);
        Node right = mergeSort(next_middle);
        Node sorted = sortMerge(left,right);
        return sorted;
    }

    private Node sortMerge(Node left, Node right) {

        Node result = null;
        if(left == null)
            return right;
        if(right == null)
            return left;

        if(left.data<=right.data){
            result = left;
            result.next = sortMerge(left.next,right);
        }else{
            result = right;
            result.next = sortMerge(left,right.next);
        }
        return result;
    }

    private Node getMiddle(Node node) {

        if(node == null)
            return node;
        Node fast = node.next;
        Node slow = node;
        while(fast!=null){
            fast = fast.next;
            if(fast!=null){
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LLMergeSort list = new LLMergeSort();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        list.display();
        list.head = list.mergeSort(list.head);
        System.out.println();
        list.display();
    }
}
