package Educative.ATM.components;

import java.util.Scanner;

public class Keypad {
    private Scanner scanner = new Scanner(System.in);

    public int getInput() {
        System.out.print("Enter input: ");
        return scanner.nextInt();
    }

    public String getStringInput() {
        System.out.print("Enter input: ");
        return scanner.next();
    }
}
