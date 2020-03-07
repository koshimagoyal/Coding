package Hackerblocks;

import java.util.ArrayList;
import java.util.Scanner;

public class SumAtLevelK {
    private static Scanner sc = new Scanner(System.in);
    class Node{
        int data;
        ArrayList<Node> children;
        Node(int data){
            this.data = data;
            this.children = new ArrayList<>();
        }
    }
    private Node root;
    private Node buildTree(Node parent,int ithChild){
        int data = sc.nextInt();
        Node node = new Node(data);
        int children = sc.nextInt();
        for(int i=0;i<children;i++){
            Node child = buildTree(node,i);
            node.children.add(child);
        }
        return node;
    }
    private int sum(Node node,int k){
        if(node == null){
            return 0;
        }
        if(k==0){
            return node.data;
        }
        int sum=0;
        for(int i=0;i<node.children.size();i++){
            sum+=sum(node.children.get(i),k-1);
        }
        return sum;
    }
    public static void main(String args[]){
        SumAtLevelK sum = new SumAtLevelK();
        sum.root = sum.buildTree(null,0);
        int k = sc.nextInt();
        System.out.println(sum.sum(sum.root,k));
    }
}
