package com.practice.binary;

import java.util.Arrays;
import java.util.Stack;

public class DecimalToBinary {

    public static void main(String[] args) {
        input1();
    }

    //Time Complexity: O(log2N)
    //Auxiliary Space: O(log2N)
    public static void decimalToBinary(int num){
        // Creating and assigning binary array size
        int[] binary = new int[35];
        int id = 0;

        while (num > 0) {
            binary[id++] = num % 2;
            num = num / 2;
        }
        System.out.println("decimalToBinary "  + Arrays.toString(binary)   + " id " + id);
        printBinary(binary, id);
    }

    static void printBinary(int[] binary, int id) {
        for (int i = id - 1; i >= 0; i--)
            System.out.print(binary[i] + "");
    }

    //Time Complexity: O(log2N)
    //Auxiliary Space: O(log2N)
    static void decimalToBinaryByStack(int num){
        Stack<Integer> st = new Stack<>();
        while (num > 0) {
            st.push(num % 2);
            num = num / 2;
        }
        while (!(st.isEmpty())) {
            System.out.print(st.pop());
        }
    }

    public static void decimalToBinary1(int num){

        String s ="";

        while(num!=0){
            if(num%2==0)
                s = s +"0";
            else
                s = s + "1";

            num = num/2;
        }

    }

    public static String reverse(String s){
        String reverse = "";
        for(int i=s.length()-1; i>=0; i--){
            reverse = reverse+ s.charAt(i);
        }
        return reverse;
    }

    static void input1(){
        int num = 45;
        decimalToBinary(num);
    }
}
