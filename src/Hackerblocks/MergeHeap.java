package Hackerblocks;

import java.util.PriorityQueue;
import java.util.Scanner;

class Node{
    int data;
    int i,j;
    Node(int data,int i,int j){
        this.data = data;
        this.i = i;
        this.j = j;
    }
}
public class MergeHeap {

        Node[] arr;
        int size;
        MergeHeap(Node arr[],int size){
            this.size = size;
            this.arr = arr;
            int i = (this.size - 1)/2;
            while (i>=0){
                heapify(i);
                i--;
            }
        }

        void heapify(int i){
            int l = left(i);
            int r = right(i);
            int smallest = i;
            if(l<size&&arr[l].data<arr[i].data){
                smallest = l;
            }
            if(r<size&&arr[r].data<arr[smallest].data){
                smallest = r;
            }
            if(smallest!=i){
                swap(arr,i,smallest);
                heapify(smallest);
            }
        }

        int left(int i){
            return (2*i+1);
        }

        int right(int i){
            return (2*i+2);
        }

        Node getMin(){
            if(size<=0){
                return null;
            }
            return arr[0];
        }

        void swap(Node arr[],int i,int j){
            Node temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        void replaceMin(Node root){
            arr[0]=root;
            heapify(0);
        }
       static void printArray(int[] arr){
            for(int i:arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }

     static void merge(int arr[][],int len) {
        Node[] array = new Node[len];
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i][0], i, 1);
            array[i] = node;
            size += arr[i].length;
        }

        MergeHeap mh = new MergeHeap(array,len);
        int[] result = new int[size];
        for (int i=0;i<size;i++){
            Node root = mh.getMin();
            result[i]=root.data;
            if(root.j<arr[root.i].length)
                root.data = arr[root.i][root.j++];
            else
                root.data = Integer.MAX_VALUE;
            mh.replaceMin(root);
        }
        printArray(result);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int [][]arr = new int[k][n];
        for(int i=0;i<k;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        merge(arr,arr.length);
    }
}
