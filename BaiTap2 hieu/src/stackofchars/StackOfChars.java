/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackofchars;

/**
 *
 * @author Admin
 */
public class StackOfChars {
    private char[] elements;
    private int size;

    public StackOfChars() {
        elements = new char[16];
        size=0;
    }
    
    public StackOfChars(int capacity) {
        elements = new char[capacity];
        size=0;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size == elements.length;
    }
    
    public int peak() {
        return elements[size-1];
    }
    
    public void push(char ch) {
        elements[size]=ch;
        size++;
    }
    
    public char pop() {
        size--;
        return elements[size];
    }

    public int getSize() {
        return size;
    }
    
}
