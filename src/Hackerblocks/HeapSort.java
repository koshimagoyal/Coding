package Hackerblocks;

import java.util.ArrayList;

public class HeapSort {
    ArrayList<Integer> data = new ArrayList<>();
    private void add(int item){
        data.add(item);
        upheapify(data.size()-1);
    }

    private void upheapify(int child_index) {

        int parent_index = (child_index -1)/2;
        if(data.get(child_index)<data.get(parent_index)){
            swap(parent_index,child_index);
            upheapify(parent_index);
        }
    }
    private void swap(int i,int j){
        int ith = data.get(i);
        int jth = data.get(j);
        data.set(i,jth);
        data.set(j,ith);
    }
    private void display(){
        System.out.println(data);
    }
    private int size(){
        return data.size();
    }
    private boolean isEmpty(){
        return size()==0;
    }
    private int remove(){
        swap(0,data.size()-1);
        int val = data.remove(data.size()-1);
        downheapify(0);
        return val;
    }

    private void downheapify(int parent_index) {
        int left_child = 2*parent_index+1;
        int right_child = 2*parent_index+2;

        int min_index = parent_index;
        if(left_child<data.size()&&data.get(left_child)<data.get(min_index)){
            min_index = left_child;
        }
        if(right_child<data.size()&&data.get(right_child)<data.get(min_index)){
            min_index = right_child;
        }
        if(min_index!=parent_index){
            swap(min_index,parent_index);
            downheapify(min_index);
        }
    }
    private int get(){
        return data.get(0);
    }
    public static void main(String args[]){
        HeapSort heap = new HeapSort();
        heap.add(10);
        heap.display();
        heap.add(20);
        heap.display();
        heap.add(30);
        heap.display();
        heap.add(40);
        heap.display();
        heap.add(5);
        heap.display();
        heap.add(3);
        heap.display();

        System.out.println(heap.remove());
        heap.display();
        System.out.println(heap.remove());
        heap.display();
        System.out.println(heap.remove());
        heap.display();
    }
}
