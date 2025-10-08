package DesignPatterns.Behavioral.Interpreter.sourcemaking;

public class StkChar {
    private char[] arr = new char[9];
    private int sp  = -1;

    void push(char ch) {
        if (!isFull()) {
            arr[++sp] = ch;
        }
    }

    char pop() {
        if (isEmpty()) {
            return '\0';
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
