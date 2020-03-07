package Hackerblocks;

import java.util.Scanner;

public class Postorder {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Postorder m = new Postorder();
        int[] post = takeInput();
        int[] in = takeInput();
        BinaryTree bt = m.new BinaryTree(post, in);
        bt.display();
    }

    public static int[] takeInput() {
        int n = scn.nextInt();

        int[] rv = new int[n];
        for (int i = 0; i < rv.length; i++) {
            rv[i] = scn.nextInt();
        }

        return rv;
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree(int[] post, int[] in) {
            this.root = this.construct(post, 0, post.length - 1, in, 0, in.length - 1);
        }

        private Node construct(int[] post, int plo, int phi, int[] in, int ilo, int ihi) {

            // write your code here
            if(ilo>ihi||phi<plo)
                return null;
            Node node = new Node();
            node.data = post[phi];
            if(ilo==ihi)
                return node;
            int index = search(in,ilo,ihi,node.data);
            int nel = index - ilo;
            node.right = construct(post,plo+nel,phi-1,in,index+1,ihi);
            node.left = construct(post,plo,plo+nel-1,in,ilo,index+1);
            return node;
        }

        int search(int in[],int ilo,int ihi,int data){
            for(int i=ilo;i<ihi;i++){
                if(data == in[i]){
                    return i;
                }
            }
            return -1;
        }
        public void display() {
            this.display(this.root);
        }

        private void display(Node node) {
            if (node == null) {
                return;
            }

            String str = "";

            if (node.left != null) {
                str += node.left.data;
            } else {
                str += "END";
            }

            str += " => " + node.data + " <= ";

            if (node.right != null) {
                str += node.right.data;
            } else {
                str += "END";
            }

            System.out.println(str);

            this.display(node.left);
            this.display(node.right);
        }

    }

}
