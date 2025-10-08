package com.datastructures.hashmap;

public class HashMapNormal {
    int arr[];
    public HashMapNormal(){
        arr = new int[100000];
        for(int i=0; i<arr.length; i++){
            arr[i] = -1;
        }
    }

    public static void main(String[] args) {
        HashMapNormal hm = new HashMapNormal();
    }

    public void put(int key, int value){
        arr[key] = value;
    }

    public int get(int key){
        return arr[key];
    }

    public void remove(int key){
        arr[key] = -1;
    }
}
