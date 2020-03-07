package Hackerblocks;

import java.util.Scanner;

public class IsBalancedTree {

        static Scanner scn = new Scanner(System.in);

        public static void main(String[] args) {
            IsBalancedTree m = new IsBalancedTree();
            BinaryTree bt = m.new BinaryTree();
            System.out.println(bt.isBalanced());
        }

        private class BinaryTree {
            private class Node {
                int data;
                Node left;
                Node right;
            }

            private Node root;
            private int size;

            public BinaryTree() {
                this.root = this.takeInput(null, false);
            }

            public Node takeInput(Node parent, boolean ilc) {

                int cdata = scn.nextInt();
                Node child = new Node();
                child.data = cdata;
                this.size++;

                // left
                boolean hlc = scn.nextBoolean();

                if (hlc) {
                    child.left = this.takeInput(child, true);
                }

                // right
                boolean hrc = scn.nextBoolean();

                if (hrc) {
                    child.right = this.takeInput(child, false);
                }

                // return
                return child;
            }

            public boolean isBalanced() {
                return this.isBalanced(this.root).isBalanced;
            }

            private BalancedPair isBalanced(Node node) {
                // write your code here
                BalancedPair bal = new BalancedPair();
                if(node==null){
                    bal.height = -1;
                    bal.isBalanced = true;
                    return bal;
                }
                BalancedPair lBal = isBalanced(node.left);
                BalancedPair rBal = isBalanced(node.right);
                bal.height = Math.max(lBal.height,rBal.height)+1;
                if(Math.abs(lBal.height-rBal.height)<=1&&(lBal.isBalanced&&rBal.isBalanced)){
                    bal.isBalanced = true;
                }else{
                    bal.isBalanced = false;
                }
                return bal;
            }

            private class BalancedPair {
                int height;
                boolean isBalanced;
            }

        }

}
