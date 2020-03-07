package Hackerblocks;

import java.util.Scanner;

public class SumOfGreaterNodes {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    private Node root;
    private Node add(int arr[],int start,int end){
        if(start>end){
            return null;
        }

        int mid = (start+end)/2;
        Node node = new Node(arr[mid]);
        node.left = add(arr,start,mid-1);
        node.right = add(arr,mid+1,end);
        return node;
    }
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    class Sum {
        int sum = 0;
    }
    private Sum s = new Sum();
    private void modify(Node node,Sum s){
        if(node == null){
            return;
        }
        modify(node.right,s);
        s.sum = s.sum + node.data;
        node.data = s.sum;
        modify(node.left,s);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        SumOfGreaterNodes tree = new SumOfGreaterNodes();
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        tree.root=tree.add(arr,0,n-1);
        tree.modify(tree.root,tree.s);
        tree.preOrder(tree.root);
    }
}
