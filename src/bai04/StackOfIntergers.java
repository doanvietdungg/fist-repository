package bai04;

/**
 *
 * @author Dao Cong Binh
 */
public class StackOfIntergers {

    private int[] elements;
    private int size;

    public StackOfIntergers() {
        elements = new int[16];
    }

    public StackOfIntergers(int size) {
        elements = new int[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return elements.length == this.size;
    }

    public int peak() {
        if (!isEmpty()) {
            return elements[size - 1];
        }
        return -1;
    }

    public void push(int value) {
        if (!isFull()) {
            size++;
            elements[size - 1] = value;
        }
    }

    public int pop() {
        int data = 0;
        if (!isEmpty()) {
            data = elements[size - 1];
            size--;
        }
        return data;
    }

    public int getSize() {
        return size;
    }
}
