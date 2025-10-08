package DesignPatterns.Behavioral.Interpreter.sourcemaking;

public class StkInt {
    private int[] arr = new int[9];
    private int   sp  = -1;

    void push(int ch) {
        if (!isFull()) {
            arr[++sp] = ch;
        }
    }

    int pop() {
        if (isEmpty()) {
            return 0;
        }
        return arr[sp--];
    }

    boolean isFull() {
        return sp == arr.length-1;
    }

    boolean isEmpty() {
        return sp == -1;
    }
}
