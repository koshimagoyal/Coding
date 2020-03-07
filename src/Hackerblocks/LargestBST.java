package Hackerblocks;

import java.util.Scanner;

public class LargestBST {
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
    static int preIndex=0;
    private Node buildTree(int pre[],int in[],int start,int end){
        if(start>end)
            return null;
        Node node = new Node(pre[preIndex++]);
        if(start==end)
            return node;
        int index = search(in,start,end,node.data);
        node.left = buildTree(pre,in,start,index-1);
        node.right = buildTree(pre,in,index+1,end);
        return node;
    }
    int search(int in[],int start,int end,int data){
        int i;
        for(i=start;i<=end;i++){
            if(in[i]==data)
                return i;
        }
        return i;
    }
    class Info{
        int size=0;
        int ans=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        boolean isBST=false;
    }
    Info largestBST(Node root){
        Info info = new Info();
        if(root == null){
            info.size=0;
            info.ans=0;
            info.max=Integer.MIN_VALUE;
            info.min=Integer.MAX_VALUE;
            info.isBST = true;
            return info;
        }
        if(root.left==null&&root.right==null){
            info.size=1;
            info.ans=1;
            info.max=root.data;
            info.min=root.data;
            info.isBST=true;
            return info;
        }
        Info left = largestBST(root.left);
        Info right = largestBST(root.right);
        info.size = (1+left.size+right.size);
        if(left.isBST&&right.isBST&&left.max<root.data&&right.min>root.data){
            info.min = Math.min(left.min,Math.min(right.min,root.data));
            info.max = Math.max(right.max,Math.max(left.max,root.data));
            info.ans = info.size;
            info.isBST = true;
            return info;
        }
        info.ans = Math.max(left.ans,right.ans);
        info.isBST = false;
        return info;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int in[] = new int[n];
        int pre[] = new int[n];
        for(int i=0;i<n;i++)
            pre[i]=sc.nextInt();
        for(int i=0;i<n;i++)
            in[i]=sc.nextInt();
        LargestBST tree = new LargestBST();
        tree.root = tree.buildTree(pre,in,0,n-1);
        System.out.println(tree.largestBST(tree.root).ans);
    }
}
