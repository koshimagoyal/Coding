package Hackerblocks;

import java.util.*;

public class VerticalOrder {
    static Scanner sc = new Scanner(System.in);
    class Node{
        long data;
        Node left;
        Node right;
        Node(long data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    Node root;
    Node insert(){
            long data = sc.nextLong();
            root = new Node(data);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node n = queue.poll();
                int c1, c2;
                c1 = sc.nextInt();
                c2 = sc.nextInt();
                if (c1 != -1) {
                    n.left = new Node(c1);
                    queue.add(n.left);
                }
                if (c2 != -1) {
                    n.right = new Node(c2);
                    queue.add(n.right);
                }
            }
        return root;
    }
    void getVertical(Node root,int hd,TreeMap<Integer,Vector<Long>> map){
        if(root == null)
            return;
        Vector<Long> get = map.get(hd);
        if(get == null){
            get = new Vector<>();
            get.add(root.data);
        }else{
            get.add(root.data);
        }
        map.put(hd,get);
        getVertical(root.left,hd-1,map);
        getVertical(root.right,hd+1,map);
    }
    void vertical(Node root){
        TreeMap<Integer, Vector<Long>> map = new TreeMap<>();
        int hd = 0;
        getVertical(root,hd,map);
        for(Map.Entry<Integer,Vector<Long>> entry:map.entrySet()){
            Vector<Long> ans = entry.getValue();
            for(int i=0;i<ans.size();i++) {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int level = sc.nextInt();
        VerticalOrder tree = new VerticalOrder();
        tree.root = tree.insert();
        tree.vertical(tree.root);
    }
}
