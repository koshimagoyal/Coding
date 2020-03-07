package Hackerblocks;

import java.util.*;

public class TreeBottomView {
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
    private void bottom(Node root){
        class QueueObj{
            Node node;
            int hd;
            QueueObj(Node node,int hd){
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> queue = new LinkedList<>();
        Map<Integer,Integer> bottomView = new TreeMap<>();
        if(root == null){
            return;
        }else{
            queue.add(new QueueObj(root,0));
        }

        while (!queue.isEmpty()){
            QueueObj tmp = queue.poll();
            //if(!bottomView.containsKey(tmp.hd)){
                bottomView.put(tmp.hd,tmp.node.data);
            //}
            if(tmp.node.left!=null){
                queue.add(new QueueObj(tmp.node.left,tmp.hd-1));
            }
            if(tmp.node.right!=null){
                queue.add(new QueueObj(tmp.node.right,tmp.hd+1));
            }
        }
        for (Map.Entry<Integer,Integer> entry:bottomView.entrySet()){
            System.out.print(entry.getValue()+" ");
        }
    }
    public static void main(String args[]){
        TreeBottomView tree = new TreeBottomView();
        tree.root = tree.buildTree();
        tree.bottom(tree.root);
    }
}
