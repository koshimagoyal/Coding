package Hackerblocks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeLeftView {
    static Scanner sc = new Scanner(System.in);
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    private Node root;
    static int max =0;
    private Node buildTree(){
        int data = sc.nextInt();
        root = new Node(data);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node n = queue.poll();
            int c1,c2;
            c1 = sc.nextInt();
            c2 = sc.nextInt();
            if(c1!=-1){
                n.left = new Node(c1);
                queue.add(n.left);
            }
            if(c2!=-1){
                n.right = new Node(c2);
                queue.add(n.right);
            }
        }
        return root;
    }
    void left(Node root,int level){
        if(root==null){
            return;
        }
        if(max<level){
            System.out.print(root.data+" ");
            max=level;
        }
        left(root.left,level+1);
        left(root.right,level+1);
    }
    public static void main(String args[]){
        TreeLeftView tree = new TreeLeftView();
        tree.root = tree.buildTree();
        tree.left(tree.root,1);
    }
}
