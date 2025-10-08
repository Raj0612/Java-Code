package com.practice;

public class Test {
    public static void main(String[] args) {
       // switchCase();


        modAndDivOperator();
    }

    static void modAndDivOperator(){
        int n = 72;
        int m = 110;

        System.out.println("Mod  " + n%m);
        System.out.println("Div  " + n/m);
    }

    static void switchCase(){
        int x =1;
        while(x<3){
            System.out.print("value of x : " + x);
            x++;
            System.out.print("\n");
        }

        int y = 1;

        switch(y){
            case 1:
                System.out.println("One");
            case 2:
                System.out.println("Two");
            default:
                System.out.println("No Match");
        }
    }
}
