package com.practice;

public class PrimeNumbers {

    public static void main(String[] args) {
        int n =40;
        boolean[] primes = new boolean[n+1];
        findPrimesNotOptimized(n, primes);
    }
    static void findPrimesNotOptimized(int n, boolean[] primes){
        for(int i= 2; i * i< n; i++){
            System.out.println("i " + i);
            if(!primes[i]){
                for(int j = i*2; j<n; j+=i){
                    primes[j] = true;
                }
                System.out.println("Added " );
                for(int k= 2; k<=n; k++){
                    if(primes[k]){
                        System.out.print( k + " ");
                    }
                }
                System.out.println(" ");
            }
        }

        for(int i= 2; i<=n; i++){
            if(!primes[i]){
                System.out.print(i + " ");
            }
        }
    }
}
