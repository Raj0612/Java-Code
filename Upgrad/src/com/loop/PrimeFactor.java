package com.loop;

import java.util.Scanner;

public class PrimeFactor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();
        for(int i = 2; i< inputNumber; i++) {
            while(inputNumber%i == 0) {
                System.out.println(i+" ");
                inputNumber /= i;
            }
        }

        if(inputNumber >2) {
            System.out.println(inputNumber);
        }


    }
}
