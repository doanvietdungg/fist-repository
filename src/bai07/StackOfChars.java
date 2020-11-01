package bai07;

/**
 *
 * @author Dao Cong Binh
 */
public class StackOfChars {

    private char[] elements;
    private int size;

    public StackOfChars() {
        elements = new char[16];
    }

    public StackOfChars(int size) {
        elements = new char[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public char peak() {
        if (!isEmpty()) {
            return elements[size - 1];
        }
        return '0';
    }

    public void push(char c) {
        if (!isFull()) {
            size++;
            elements[size - 1] = c;
        }
    }

    public char pop() {
        char c = '0';
        if (!isEmpty()) {
            c = elements[size - 1];
            size--;
        }
        return c;
    }

    public int getSize() {
        return size;
    }
    
    
}
