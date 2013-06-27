package com.practicejava.heaps;

import java.util.ArrayList;

/**
 *
 * @author Barbara Bickham
 */
public class BinaryHeap {

    private static int[] input = new int[]{-1,4,7,6,9,3,2,1};
    private static BinaryHeapNode[] nodes = new BinaryHeapNode[input.length];
    private static int MAX_NODES = 1;
   
    public static void main(String args[]) {

        for(int i=1; i<input.length; i++){
            System.out.print(input[i] + " ");
            BinaryHeapNode node = new BinaryHeapNode(i);
            nodes[MAX_NODES++] = node;
            if(i==1){
                continue;
            }
            setParent(i);
            insertNode(i, input[i]);
        }
        System.out.println(" ");
        /* final binary heap */
        for(int i=1; i<input.length; i++){
            System.out.print(input[i] + " ");
        }
        System.out.println(" ");
    }

    private static void setParent(int index){
        while(true){
            BinaryHeapNode parent = nodes[index/2];
            if(parent.isLeftChild()){
                parent.setChild(true, index);
                return;
            }else if(parent.isRightChild()){
                parent.setChild(false, index);
                return;
            }
        }
    }

    private static void insertNode(int index, int value){
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        indexes.add(index);
        int parent_index = index/2;
        while(parent_index >= 1){
            if(input[parent_index] > value){
                indexes.add(parent_index);
            }
            parent_index /= 2;
        }
        Integer[] replace = (Integer[])indexes.toArray(new Integer[0]);
        for(int i = 0; i <replace.length-1; i++){
            input[replace[i]] = input[replace[i+1]];
        }
        input[replace[replace.length-1]] = value;
    }
}
