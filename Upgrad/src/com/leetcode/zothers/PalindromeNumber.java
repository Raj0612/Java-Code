package com.leetcode.zothers;

//Given an integer x, return true if x is a  palindrome , and false otherwise.

/*Example 1:
        Input: x = 121
        Output: true
        Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
        Input: x = -121
        Output: false
        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.*/
public class PalindromeNumber {

    public static void main(String[] args) {
        int x = 0;
        x = 121;
       // x = 11119999;
        System.out.println("isPalindrome " + isPalindrome(x));
        System.out.println("isPalindrome1 " + isPalindrome1(x));
        String str = Integer.toString(x);
        System.out.println("usingRecursion " + usingRecursion(str, 0, str.length()-1));
    }

    static boolean isPalindrome(int x){
        if(x<0){
            return false;
        }
        int rem=0;
        int sum=0;
        int temp=x;
        while(x>0){
            rem=x%10;
            sum=(sum*10)+rem;
            x=x/10;
            System.out.println("rem:" + rem + " sum:" + sum +" x:" + x);
        }
        if(temp==sum){
            return true;
        }
        return false;
    }

    private static boolean usingRecursion(String str, int i, int j) {
        if (i >= j) return true;
        if (str.charAt(i) != str.charAt(j)) return false;
        return usingRecursion(str, i + 1, j - 1);
    }

    static boolean isPalindrome1(int x) {

        if (x < 0)
            return false;
        String str = Integer.toString(x);

        int i = 0;
        int j = str.length()-1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            else {
                i++;
                j--;
            }

        }
        return true;
    }
}
