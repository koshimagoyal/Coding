package Hackerblocks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeRightView {
    private static Scanner sc = new Scanner(System.in);
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
    private static int max=0;
    private Node buildTree(){
        int data = sc.nextInt();
        root = new Node(data);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            if(c1!=-1){
                node.left = new Node(c1);
                queue.add(node.left);
            }
            if(c2!=-1){
                node.right = new Node(c2);
                queue.add(node.right);
            }
        }
        return root;
    }
    void right(Node root,int level){
        if(root==null){
            return;
        }
        if(max<level){
            System.out.print(root.data+" ");
            max = level;
        }
        right(root.right,level+1);
        right(root.left,level+1);
    }
    public static void main(String args[]){
        TreeRightView tree = new TreeRightView();
        tree.root = tree.buildTree();
        tree.right(tree.root,1);
    }
}
