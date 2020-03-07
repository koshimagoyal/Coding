package Hackerblocks;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class PrintSumK {
    static TreeSet<Integer> ans = new TreeSet<>();
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

    void print(Node node,int k){
        if(node == null||k<0)
            return;
        if(k==0){
            ans.add(node.data);
            return;
        }
        print(node.left,k-1);
        print(node.right,k-1);
    }

    int printDist(Node node,int target,int k){
        if(node == null){
            return -1;
        }
        if(node.data==target){
            print(node,k);
            return 0;
        }
        int d1 = printDist(node.left,target,k);
        if(d1!=-1){
            if(d1+1==k){
                ans.add(node.data);
            }else {
                print(node.right,k-d1-2);
            }
            return 1+d1;
        }
        int dr = printDist(node.right,target,k);
        if(dr!=-1){
            if(dr+1==k){
                ans.add(node.data);
            }else {
                print(node.left,k-dr-2);
            }
            return 1+dr;
        }
        return -1;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int in[] = new int[n];
        int pre[] = new int[n];
        for(int i=0;i<n;i++){
            pre[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            in[i]=sc.nextInt();
        }
        PrintSumK tree = new PrintSumK();
        tree.root = tree.buildTree(pre,in,0,n-1);
        int l = sc.nextInt();
        for(int i=0;i<l;i++){
            int target = sc.nextInt();
            int k = sc.nextInt();
            tree.printDist(tree.root,target,k);
            Iterator itr = ans.iterator();
            while(itr.hasNext()){
                System.out.print(itr.next()+" ");
            }
            ans.clear();
            System.out.println();
        }
    }
}
