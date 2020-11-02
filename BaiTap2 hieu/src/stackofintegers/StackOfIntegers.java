/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackofintegers;

import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class StackOfIntegers {
    private int[] elements; //các số nguyên trong stack
    private int size;      //số lượng số nguyên trong stack

    public StackOfIntegers() {
        elements = new int[16];
        size = 0;
    }
    
    public StackOfIntegers(int capacity) {
        elements = new int[capacity];
        size = 0;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == elements.length;
    }
    
    public int peak() {
        return elements[size-1];
    }
    
    public void push(int value) {
        elements[size] = value;
        size++;
    }
    
    public int pop() {
        size--;
        return elements[size];
    }

    public int getSize() {
        return size;
    }
    
    public void sortInteger(){
        Arrays.sort(elements);
    }
}
