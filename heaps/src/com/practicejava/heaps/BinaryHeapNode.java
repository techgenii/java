package com.practicejava.heaps;

/**
 *
 * @author Barbara Bickham
 */
public class BinaryHeapNode {

    private int value;
    private int left;
    private int right;

    public BinaryHeapNode(int v){
        this.value = v;
        this.left = -1;
        this.right = -1;
    }

    public int getValue(){
        return this.value;
    }

    public void setChild(boolean left, int index){
        if(left){
            this.left = index;
        }else{
            this.right = index;
        }
    }

    public int getChild(boolean left){
        if(left){
            return this.left;
        }else{
            return this.right;
        }
    }
    public boolean isLeftChild(){
        return (this.left == -1);
    }

    public boolean isRightChild(){
        return (this.right == -1);
    }
}