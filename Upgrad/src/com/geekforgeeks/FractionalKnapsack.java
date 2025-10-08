package com.geekforgeeks;
//Given two arrays, val[] and wt[], representing the values and weights of items, and an integer capacity representing the maximum weight a knapsack can hold,
// the task is to determine the maximum total value that can be achieved by putting items in the knapsack. You are allowed to break items into fractions if necessary.
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static void main(String[] args) {

        Item item1  = new Item();
        Item item2  = new Item();
        Item item3  = new Item();
        Item item4  = new Item();

        item1.value = 60;
        item2.value = 120;
        item3.value = 100;
        item4.value = 120;

        item1.weight = 10;
        item2.weight = 30;
        item3.weight = 20;
        item4.weight = 30;

        Item arr[] = new Item[4];
        arr[0] = item1;
        arr[1] = item2;
        arr[2] = item3;
        arr[3] = item4;

        int weight = 50;
        int n = 4;

        double result = fractionalKnapsack(weight, arr, n);
        System.out.println("Result " + result);

    }

    //Time - O(nlogn) + O(n) == O(nlogn)
    static double  fractionalKnapsack(int W, Item arr[], int n){
        System.out.println("fractionalKnapsack arr " + Arrays.toString(arr));
        Arrays.sort(arr, compareByRate);
        System.out.println("fractionalKnapsack arr1 " + Arrays.toString(arr));
        double ans =0;

        // can use while(W<=0)
        for(int i=0; i< arr.length; i++){
            int val = arr[i].value;
            int weight = arr[i].weight;

            if(W - weight >= 0){
                W = W - weight;
                ans = ans + val;
            }else{
                double fraction = (double) W/ (double)weight;
                int frac = W/weight;
                System.out.println("frac " + frac + " (val * fraction) " + (val * fraction));
                ans = ans + (val * fraction);
              // W = (int) (W- (weight * fraction));
                break;
            }
        }
        return ans;

    }

    static Comparator<Item> compareByRate = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            double rate1 = (double)o1.value / (double)o1.weight;
            double rate2 = (double)o2.value / (double)o2.weight;

            if(rate1 < rate2)
                return 1;
            else if (rate1 > rate2)
                return -1;
            else
                return 0;
        }
    };
}


class Item{

    int value;

    int weight;

    @Override
    public String toString() {
        return "Item{" +
                "value=" + value +
                ", weight=" + weight +
                '}';
    }
}
